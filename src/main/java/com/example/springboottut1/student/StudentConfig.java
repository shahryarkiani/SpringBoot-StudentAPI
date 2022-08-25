package com.example.springboottut1.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student bobby = new Student(
                    "Bobby",
                    "Bobby.Joes@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student Alex = new Student(
                    "Alex",
                    "Alex.Steves@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 5)
            );

            repository.saveAll(
                    List.of(bobby, Alex)
            );
        };
    }
}
