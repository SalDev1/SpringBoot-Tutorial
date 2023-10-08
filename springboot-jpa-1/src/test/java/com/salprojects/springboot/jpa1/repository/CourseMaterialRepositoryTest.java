package com.salprojects.springboot.jpa1.repository;

import com.salprojects.springboot.jpa1.entity.Course;
import com.salprojects.springboot.jpa1.entity.CourseMaterial;
import com.salprojects.springboot.jpa1.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial() {
        Course course = Course.builder().title(".NET").credit(6).build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.instagram.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }


    @Test
    public void printAllCoursesMaterial() {
        List<CourseMaterial> courseMaterials =
                repository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}