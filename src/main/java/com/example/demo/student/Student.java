package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity // Hibernate
@Table // Saying that this class is a table on database.
public class Student {
    @Id // Saying that Student.id is our ID on database.
    @SequenceGenerator( // Creating a sequence.
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue( // Saying what Sequence are we going to use to generate our IDs.
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String nif;
    @Transient // Ignores this as column to database.
    private Integer age;

    public Student() {

    }

    public Student(String name, String email, LocalDate dob, String nif) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.nif = nif;
    }

    public Student(Long id, String name, String email, LocalDate dob, String nif) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.nif = nif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        // This will calculate age automatically.
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", nif='" + nif + '\'' +
                ", age=" + age +
                '}';
    }
}
