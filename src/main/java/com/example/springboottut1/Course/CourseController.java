package com.example.springboottut1.Course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses(){return courseService.getCourses();}

    @GetMapping(path = "{courseId}")
    public Optional<Course> getCourse(@PathVariable("courseId") Long courseId){
        return courseService.getCourse(courseId);
    }

    @PostMapping(path = "{courseId}/email")
    public void sendEmail(@PathVariable("courseId") Long courseId, @RequestBody String message){
        courseService.sendEmailToAllStudents(message, courseId);
    }

    @PostMapping
    public void addNewCourse(@RequestBody Course newCourse){courseService.addNewCourse(newCourse);}

    @PutMapping(path = "{courseId}")
    public void addStudentToCourse(@RequestBody Long studentId, @PathVariable("courseId") Long courseId){
        courseService.addNewStudent(studentId, courseId);
    }

}
