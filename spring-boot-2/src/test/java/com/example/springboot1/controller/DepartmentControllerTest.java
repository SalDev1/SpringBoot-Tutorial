package com.example.springboot1.controller;

import com.example.springboot1.entity.Department;
import com.example.springboot1.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Department.class)
class DepartmentControllerTest {

    // Mock the MVC

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().departmentAddress("Ahmedabad")
                .departmentCode("IT-11")
                .departmentId(1L)
                .departmentName("IT")
                .build();
    }

    @Test
    void saveDepartment() throws Exception{
        Department inputDepartment = Department
                .builder().departmentAddress("Ahmedabad")
                .departmentCode("IT-11")
                .departmentId(1L)
                .departmentName("IT")
                .build();

        Mockito.when(departmentService
                .saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"departmentName\":\"IT\",\n" +
                                "\t\"departmentAddress\":\"Ahmedabad\",\n" +
                                "\t\"departmentCode\":\"IT-06\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    // Creating a mock method for the given method down below.

    // // The department I am getting should match with the
    // JSON department name
//    @Test
//    void fetchDepartmentById() throws Exception{
//        Mockito.when(departmentService.fetchDepartmentById(1L))
//                .thenReturn(department);
//
//        mockMvc.perform(get("/department/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.departmentName").
//                        value(department.getDepartmentName()));
//    }
}