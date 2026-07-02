package com.example.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;
import com.example.employeemanagementsystem.projection.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CRUD

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {

            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setDepartment(employee.getDepartment());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }

    public String deleteEmployee(Long id) {

        employeeRepository.deleteById(id);

        return "Employee Deleted Successfully";
    }

    // Derived Queries

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findByEmailContaining(String email) {
        return employeeRepository.findByEmailContaining(email);
    }

    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartmentName(department);
    }

    public List<Employee> findByNameStartingWith(String prefix) {
        return employeeRepository.findByNameStartingWith(prefix);
    }

    public List<Employee> findByNameEndingWith(String suffix) {
        return employeeRepository.findByNameEndingWith(suffix);
    }

    public List<Employee> findByNameContaining(String keyword) {
        return employeeRepository.findByNameContaining(keyword);
    }

    public List<Employee> findByNameIgnoreCase(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }

    // JPQL

    public List<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.getEmployeeByEmail(email);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.getEmployeesByDepartment(department);
    }

    // Native Query

    public List<Employee> getEmployeeNative(String name) {
        return employeeRepository.getEmployeeNative(name);
    }

    // Named Query

    public List<Employee> findEmployeeByNameUsingNamedQuery(String name) {
        return employeeRepository.findEmployeeByNameUsingNamedQuery(name);
    }

    public List<Employee> findEmployeeByEmailUsingNamedQuery(String email) {
        return employeeRepository.findEmployeeByEmailUsingNamedQuery(email);
    }

    // ==========================
    // Pagination
    // ==========================

    public Page<Employee> getEmployees(Pageable pageable) {

        return employeeRepository.findAll(pageable);

    }

    // ==========================
    // Sorting
    // ==========================

    public List<Employee> getEmployeesSorted(String field) {

        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));

    }

    // ==========================
// Interface Projection
// ==========================

public List<EmployeeView> getEmployeeView() {

    return employeeRepository.findBy();

}

// ==========================
// DTO Projection
// ==========================

public List<EmployeeDTO> getEmployeeDTO() {

    return employeeRepository.getEmployeeDTO();

}
}