package com.sal.springboot.learnjpaandhibernate.jpa;

import com.sal.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class CourseJPARepository  {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }
    public Course findById(long id) {
        return entityManager.find(Course.class,id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }
}
