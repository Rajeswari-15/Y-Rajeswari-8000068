package com.example.employeemanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Create Department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {

        return departmentService.saveDepartment(department);

    }

    // Get All Departments
    @GetMapping
    public List<Department> getAllDepartments() {

        return departmentService.getAllDepartments();

    }

    // Get Department By Id
    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id) {

        return departmentService.getDepartmentById(id);

    }

    // Update Department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id,
                                       @RequestBody Department department) {

        return departmentService.updateDepartment(id, department);

    }

    // Delete Department
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {

        return departmentService.deleteDepartment(id);

    }

}