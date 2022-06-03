package com.example.springboottut1.student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private LocalDate dateOfBirth;


    public Student() {
    }


    public Student(Long id, String name, Integer age, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    
    public Student(String name, Integer age, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }   

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", email='" + getEmail() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            "}";
    }


}
