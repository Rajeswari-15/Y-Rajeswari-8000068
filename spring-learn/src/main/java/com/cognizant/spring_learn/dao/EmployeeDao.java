package com.cognizant.spring_learn.dao;

import java.util.ArrayList;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.exception.EmployeeNotFoundException;

public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST = new ArrayList<>();

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId() == employee.getId()) {
                EMPLOYEE_LIST.set(i, employee);
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public void deleteEmployee(int id)
            throws EmployeeNotFoundException {

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId() == id) {
                EMPLOYEE_LIST.remove(i);
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }
}