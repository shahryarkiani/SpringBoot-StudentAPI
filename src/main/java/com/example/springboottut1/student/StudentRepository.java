package com.example.springboottut1.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {




}
