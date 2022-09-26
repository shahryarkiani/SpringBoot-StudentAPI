package com.example.springboottut1.Course;

import com.example.springboottut1.student.Student;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1,
            initialValue =  111)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;

    private String courseName;

    @ManyToMany
    private Set<Student> students;

    public Long getId() {
        return id;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Course(String courseName, Set<Student> students)
    {
        this.courseName = courseName;
        this.students = students;
    }

    public Course(String courseName)
    {
        this.courseName = courseName;
        this.students = new TreeSet<>();
    }

    public Course()
    {

    }

}
