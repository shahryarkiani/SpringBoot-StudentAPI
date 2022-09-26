package com.example.springboottut1.student;

import com.example.springboottut1.Course.Course;
import com.example.springboottut1.Course.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            CourseRepository courseRepository,
            StudentRepository studentRepository) {
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

            studentRepository.saveAll(
                    List.of(bobby, Alex)
            );

            Set<Student> studentSet = new TreeSet<>();

            studentSet.add(Alex);
            studentSet.add(bobby);

            Course math = new Course("LinearAlgebra", studentSet);
            Course read = new Course("English101", studentSet);

            courseRepository.save(math);
            courseRepository.save(read);
        };
    }
}
