package com.cognizant.spring_learn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.EmployeeService;
import com.cognizant.spring_learn.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService service = new EmployeeService();

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee)
            throws EmployeeNotFoundException {
        service.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id)
            throws EmployeeNotFoundException {
        service.deleteEmployee(id);
    }
}