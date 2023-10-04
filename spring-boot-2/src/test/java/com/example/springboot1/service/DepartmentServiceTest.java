package com.example.springboot1.service;

import com.example.springboot1.entity.Department;
import com.example.springboot1.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


// To tell spring boot that
// this is a test class we use this
// annotation.
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    // We try to create a mock of it.
    @MockBean
    private DepartmentRepository departmentRepository;


    @BeforeEach
    void setUp() {
        Department department = Department
                .builder()
                .departmentName("IT")
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-234")
                .departmentId(1L)
                .build();

        // Whenever findByDepartmentNameIgnoreCase method is been
        // called then I want department defined above to be returned.
        Mockito.when(departmentRepository.
                findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }


    @Test
    @DisplayName("Get Data based on Valid Department Name ")
    public void  whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        // If both are equal, my testcase is passed , otherwise it will not.
        assertEquals(departmentName , found.getDepartmentName());
    }
}