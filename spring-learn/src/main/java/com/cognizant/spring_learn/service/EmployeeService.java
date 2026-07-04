package com.cognizant.spring_learn.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

    private EmployeeDao dao = new EmployeeDao();

    public ArrayList<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {
        dao.updateEmployee(employee);
    }

    public void deleteEmployee(int id)
            throws EmployeeNotFoundException {
        dao.deleteEmployee(id);
    }
}