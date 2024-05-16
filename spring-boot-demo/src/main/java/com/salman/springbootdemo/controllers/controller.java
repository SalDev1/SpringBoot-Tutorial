package com.salman.springbootdemo.controllers;


import com.salman.springbootdemo.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/courses")
    public List<Course> getAllCourses() {
        Course c1 = new Course(1 , "AWS" , "Salman");
        Course c2 = new Course(2 , "Docker" , "Sam");
        Course c3 = new Course(3 , "SpringBoot" , "Salman");
        Course c4 = new Course(4 , "Azure" , "Salman");
        List<Course> courses = List.of(c1 ,c2 ,c3,c4);
        return courses;
    }
}
