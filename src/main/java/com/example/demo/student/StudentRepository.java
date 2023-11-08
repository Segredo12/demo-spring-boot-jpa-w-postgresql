package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { // DATA ACCESS LAYER

    // @Query("SELECT s FROM student s WHERE s.email = ?1")
    // OR
    // SELECT * FROM student WHERE email = {email}
    Optional<Student> findByEmail(String email);
    Optional<Student> findByNif(String nif);
}
