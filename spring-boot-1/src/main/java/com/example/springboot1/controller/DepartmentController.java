package com.example.springboot1.controller;

import com.example.springboot1.entity.Department;
import com.example.springboot1.error.DepartmentNotFoundException;
import com.example.springboot1.service.DepartmentService;
import com.example.springboot1.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// We are creating REST API for the department entity.
// We must also added services and repository for department as well.
@RestController
public class DepartmentController {


    // Give authority to spring or autowired the object from spring container
    // to bring us the Department service object over here.

    // It gives the object that we want (Property Based Dependency
    // Injection)
    @Autowired
    private DepartmentService departmentService;
    // This post request will try to save a department
    // in database.

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    // I will convert entire JSON object coming over here
    // into an entity
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        // JSON Data --> Department object
        // @RequestBody --> Entire JSON object is converted into department object.
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    // Getting all departments table data from h2 database
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    // Getting department by their unique id.
    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
    // Deleting data by department id
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") long departmentId , @RequestBody Department department) {
        // We need two things , path variable and request body.
        return departmentService.updateDepartment(departmentId ,department);
    }

    // Get department by their name
    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
