package com.salprojects.springboot.jpa1.repository;

import com.salprojects.springboot.jpa1.entity.Course;
import com.salprojects.springboot.jpa1.entity.Student;
import com.salprojects.springboot.jpa1.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;


    // Due to bidirectional relation between
    // course and courseMaterial

    // You are getting courseMaterial info along
    // with the course info too.
    @Test
    public void printCourse() {
        List<Course> courses = repository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacherObject() {
        Teacher teacher = Teacher
                .builder()
                .firstName("Naisha")
                .lastName("Sharma")
                .build();

        Course course  = Course
                .builder()
                .title("Python")
                .credit(10)
                .teacher(teacher)
                .build();
        repository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);

        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses = repository.
                findAll(secondPageWithTwoRecords).getContent();

        long totalElements = repository.
                findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = repository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("totalElements = " + totalElements);

        System.out.println("totalPages = " + totalPages);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.
                of(0,2 , Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(
                0,2,Sort.by("credit").descending()
        );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = repository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    // Get you a list of courses starting with the letter "D"
    @Test
    public void printfindByTitleContaining() {
         Pageable firstPageTenRecords =
           PageRequest.of(0,10);

         List<Course> courses =
                 repository.findByTitleContaining("D" , firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Linka")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("John")
                .lastName("Owens")
                .emailId("johnowens@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        repository.save(course);
    }
}