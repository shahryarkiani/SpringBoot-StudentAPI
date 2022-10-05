package com.example.springboottut1.Course;


import com.example.springboottut1.Email.EmailService;
import com.example.springboottut1.student.Student;
import com.example.springboottut1.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;

    private final EmailService emailService;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentService studentService, EmailService emailService){
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.emailService = emailService;
    }

    public List<Course> getCourses(){
       return courseRepository.findAll();
    }

    public Optional<Course> getCourse(Long courseId)
    {
        return courseRepository.findById(courseId);
    }

    public void addNewCourse(Course course){
        Optional<Course> courseOptional = courseRepository.findByCourseName(course.getCourseName());

        if(courseOptional.isPresent())
        {
            throw new IllegalStateException("This course name is taken");
        }
        courseRepository.save(course);
    }

    public void addNewStudent(Long studentId, Long courseId) {
        Optional<Student> studentOptional = studentService.getStudent(studentId);
        if(studentOptional.isPresent())
        {
            Optional<Course> optionalCourse = courseRepository.findById(courseId);
            if(optionalCourse.isPresent())
            {
                Course course = optionalCourse.get();
                course.addStudent(studentOptional.get());
                courseRepository.save(course);
            }
            else
            {
                throw new IllegalStateException("Course does not exist");
            }
        }
        else{
            throw new IllegalStateException("Student does not exist");
        }
    }

    private String[] getAllStudentEmails(Set<Student> students){
        return students.stream().map(Student::getEmail).toArray(String[]::new);
    }

    public void sendEmailToAllStudents(String message, Long courseId)
    {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if(optionalCourse.isPresent())
        {
            Course course = optionalCourse.get();
            Set<Student> students = course.getStudents();
            if(!students.isEmpty()) {
                emailService.sendEmailToList(getAllStudentEmails(students),message);
            }
        }
        else {
            throw new IllegalStateException("Course does not exist");
        }
    }
}
