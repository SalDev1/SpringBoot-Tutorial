package com.salprojects.springboot.jpa1.repository;

import com.salprojects.springboot.jpa1.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    // Whatever data you passed , you will get object as PageRequest.
    Page<Course> findByTitleContaining(
            String title,
            Pageable pageable
    );

}
