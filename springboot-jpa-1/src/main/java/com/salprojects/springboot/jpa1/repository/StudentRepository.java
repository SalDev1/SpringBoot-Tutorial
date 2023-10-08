package com.salprojects.springboot.jpa1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.salprojects.springboot.jpa1.entity.Student;

import java.util.List;

/**
 * StudentRepositoty
 * 
 * In JPARepository , we have two parameters.
 * 1] Entity
 * 2] Type of entity.
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
     List<Student> findByFirstName(String firstName);

    // I want a method that matches some chars in the name that we get.
    List<Student> findByFirstNameContaining(String name);

//    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

//    Student findByLastnameOrFirstname(String lastName , String firstName);

    // JPQL --> This is based on the classes you have not
    // the tables in the database.
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getFirstNameStudentByEmailAddress(String emailId);

    // Native SQL Query.
    @Query (
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    // When we are dealing with more kind of params we use the syntax down below.
    // Native Named Param
    @Query (
        value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
        nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );


    // As we are modifying the data , there must be a transaction or commit final changes into
    // the database , currently we are focusing on the repository layer.
    @Modifying
    @Transactional
    @Query (
            value = "update tbl_student set first_name = ?1 where email_address = ?1",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
