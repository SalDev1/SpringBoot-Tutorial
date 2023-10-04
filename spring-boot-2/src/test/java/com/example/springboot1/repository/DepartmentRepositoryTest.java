package com.example.springboot1.repository;

import com.example.springboot1.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;



// Unit Testing in Repository Layer.
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;


    @Autowired
    private TestEntityManager entityManager;


    // We are successfully able to test our repository layer ,
    // without harming the database itself.
    @BeforeEach
    // Before calling each testcase , we create this method , push
    // it in the database , saving and mocking it and when the
    // execution is done , the particular data will be deleted.
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentCode("ME - 011")
                .departmentAddress("Delhi")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }
}