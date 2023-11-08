package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration // Saying that this file is a config file.
public class StudentConfig {

    @Bean // Saying that this line is going to run.
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            // Here we create our students to be later inserted onto database.
            // This is executed on the start of the application.
            Student octavio = new Student(
                    "Octávio",
                    "octavio12@live.com.pt",
                    LocalDate.of(1996, Month.APRIL, 14),
                    "000000000"
            );
            Student carina = new Student(
                    "Carina",
                    "carinacid@live.com.pt",
                    LocalDate.of(1998, Month.OCTOBER, 17),
                    "000000001"
            );
            if (!repository.findByEmail(octavio.getEmail()).isPresent())
                repository.save(octavio);
            if (!repository.findByEmail(carina.getEmail()).isPresent())
                repository.save(carina);
        };
    }
}
