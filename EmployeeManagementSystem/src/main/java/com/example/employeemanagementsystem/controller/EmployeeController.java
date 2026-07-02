package com.example.employeemanagementsystem.controller;

import java.util.List;
import java.util.Optional;
import com.example.employeemanagementsystem.projection.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // CRUD

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);

    }

    @GetMapping
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();

    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {

        return employeeService.getEmployeeById(id);

    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);

    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        return employeeService.deleteEmployee(id);

    }

    // Derived Queries

    @GetMapping("/name/{name}")
    public List<Employee> findByName(@PathVariable String name) {

        return employeeService.findByName(name);

    }

    @GetMapping("/email/{email}")
    public List<Employee> findByEmail(@PathVariable String email) {

        return employeeService.findByEmailContaining(email);

    }

    @GetMapping("/department/{department}")
    public List<Employee> findByDepartment(@PathVariable String department) {

        return employeeService.findByDepartment(department);

    }

    // JPQL

    @GetMapping("/jpql/{email}")
    public List<Employee> jpql(@PathVariable String email) {

        return employeeService.getEmployeeByEmail(email);

    }

    // Native Query

    @GetMapping("/native/{name}")
    public List<Employee> nativeQuery(@PathVariable String name) {

        return employeeService.getEmployeeNative(name);

    }

    // Named Query

    @GetMapping("/named/{name}")
    public List<Employee> namedQuery(@PathVariable String name) {

        return employeeService.findEmployeeByNameUsingNamedQuery(name);

    }

    // ==========================
    // Pagination
    // ==========================

    @GetMapping("/page")
    public Page<Employee> pagination(Pageable pageable) {

        return employeeService.getEmployees(pageable);

    }

    // ==========================
    // Sorting
    // ==========================

    @GetMapping("/sort/{field}")
    public List<Employee> sorting(@PathVariable String field) {

        return employeeService.getEmployeesSorted(field);

    }
    // ==========================
// Interface Projection
// ==========================

@GetMapping("/projection")
public List<EmployeeView> projection() {

    return employeeService.getEmployeeView();

}

// ==========================
// DTO Projection
// ==========================

@GetMapping("/dto")
public List<EmployeeDTO> dtoProjection() {

    return employeeService.getEmployeeDTO();

}

}