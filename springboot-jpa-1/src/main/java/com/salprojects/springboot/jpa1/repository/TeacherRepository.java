package com.salprojects.springboot.jpa1.repository;

import com.salprojects.springboot.jpa1.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
