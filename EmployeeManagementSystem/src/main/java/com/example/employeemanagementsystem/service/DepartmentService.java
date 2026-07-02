package com.example.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create Department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get All Departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get Department By Id
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Update Department
    public Department updateDepartment(Long id, Department department) {

        Department existingDepartment = departmentRepository.findById(id).orElse(null);

        if (existingDepartment != null) {

            existingDepartment.setName(department.getName());

            return departmentRepository.save(existingDepartment);
        }

        return null;
    }

    // Delete Department
    public String deleteDepartment(Long id) {

        departmentRepository.deleteById(id);

        return "Department Deleted Successfully";
    }

}