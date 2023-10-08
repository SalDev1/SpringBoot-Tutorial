package com.salprojects.springboot.jpa1.repository;

import com.salprojects.springboot.jpa1.entity.CourseMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

}
