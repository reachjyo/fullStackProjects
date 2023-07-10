package com.parimi.studentservices.controller;


import com.parimi.studentservices.model.StudentRegisteredCourse;
import com.parimi.studentservices.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}/courses")
    public List<StudentRegisteredCourse> retrieveCoursesForStudent(@PathVariable String studentId) {
        return studentService.retrieveCourses(studentId);
    }
}
