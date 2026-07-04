package com.cognizant.spring_learn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.spring_learn.model.Department;

@Repository
public class DepartmentDao {

    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        DEPARTMENT_LIST = new ArrayList<>();

        DEPARTMENT_LIST.add(context.getBean("dept1", Department.class));
        DEPARTMENT_LIST.add(context.getBean("dept2", Department.class));
        DEPARTMENT_LIST.add(context.getBean("dept3", Department.class));

    }

    public ArrayList<Department> getAllDepartments() {

        return DEPARTMENT_LIST;

    }

}