package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service // Creating a Service bean. (So we can use as Autowired)
public class StudentService { // SERVICE LAYER OR BUSINESS LAYER
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public void addNewStudent(Student student) {
        // We're going to validate if email already in use.
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already in use.");
        }
        if (studentRepository.findByNif(student.getNif()).isPresent())
            throw new IllegalStateException("NIF already in use.");
        // In case email is not in use we're going to save it.
        studentRepository.save(student);
    }
    public void deleteStudent(Long studentId) {
        // Let's see if exists a student on database with this id.
        if (!studentRepository.existsById(studentId))
            throw new IllegalStateException("ID doesn't exist on the system.");
        studentRepository.deleteById(studentId);
    }
    @Transactional // This annotation make entity enter a manage state. (So we dont need to use SQL Queries)
    public void updateStudent(Long studentId, String name, String email) {
        Student studentToUpdate = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("ID doesn't exist on the system."));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(studentToUpdate.getName(), name))
            studentToUpdate.setName(name);

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(studentToUpdate.getEmail(), email)) {
            if (studentRepository.findByEmail(email).isPresent())
                throw new IllegalStateException("Email already in use.");
            studentToUpdate.setEmail(email);
        }
    }
}