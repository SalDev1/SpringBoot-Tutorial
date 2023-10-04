package com.example.springboot1.service;

import com.example.springboot1.entity.Department;
import com.example.springboot1.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    Department fetchDepartmentById(long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
