package com.sal.springboot.learnjpaandhibernate;

import com.sal.springboot.learnjpaandhibernate.course.Course;
import com.sal.springboot.learnjpaandhibernate.jpa.CourseJPARepository;
import com.sal.springboot.learnjpaandhibernate.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // Spring Data Repository.
    @Autowired
    public CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // repository.insert();
        repository.save(new Course(1,"Learn AWS Now!","Piyush"));
        repository.save(new Course(2,"Learn Devops Now!","Piyush"));
        repository.save(new Course(3,"Learn Azure Now!","Piyush"));

        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findAll());

        System.out.println(repository.findByAuthor("Piyush"));

        System.out.println(repository.findByName("Learn Azure Now!"));
    }

    // JPA Repository
    //    @Autowired
//    private CourseJPARepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // repository.insert();
//        repository.insert(new Course(1,"Learn AWS Now!","Piyush"));
//        repository.insert(new Course(2,"Learn Devops Now!","Piyush"));
//        repository.insert(new Course(3,"Learn Azure Now!","Piyush"));
//
//        repository.deleteById(1);
//
//        System.out.println(repository.findById(2));
//    }


    // Spring JDBC Configuration.
//    @Autowired
//    private CourseJDBCRepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // repository.insert();
////        repository.insert(new Course(1,"Learn AWS Now!","Piyush"));
////        repository.insert(new Course(2,"Learn Devops Now!","Piyush"));
////        repository.insert(new Course(3,"Learn Azure Now!","Piyush"));
////
////        repository.delete(1);
////
////        System.out.println(repository.findById(2));
//    }
}
