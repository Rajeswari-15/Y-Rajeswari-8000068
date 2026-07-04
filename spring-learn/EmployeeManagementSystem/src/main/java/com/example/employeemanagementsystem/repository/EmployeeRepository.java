package com.example.employeemanagementsystem.repository;
import java.util.List;

import com.example.employeemanagementsystem.projection.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employeemanagementsystem.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // ==========================
    // Derived Query Methods
    // ==========================

    List<Employee> findByName(String name);

    List<Employee> findByEmailContaining(String email);

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByNameStartingWith(String prefix);

    List<Employee> findByNameEndingWith(String suffix);

    List<Employee> findByNameContaining(String keyword);

    List<Employee> findByNameIgnoreCase(String name);

    // ==========================
    // JPQL Queries
    // ==========================

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    List<Employee> getEmployeeByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.department.name = ?1")
    List<Employee> getEmployeesByDepartment(String department);

    // ==========================
    // Native SQL Query
    // ==========================

    @Query(value = "SELECT * FROM employees WHERE name = ?1", nativeQuery = true)
    List<Employee> getEmployeeNative(String name);

    // ==========================
    // Named Queries
    // ==========================

    @Query(name = "Employee.findByEmployeeName")
    List<Employee> findEmployeeByNameUsingNamedQuery(String name);

    @Query(name = "Employee.findEmployeeByEmail")
    List<Employee> findEmployeeByEmailUsingNamedQuery(String email);

    // ===============================
// Interface Projection
// ===============================

List<EmployeeView> findBy();

// ===============================
// Class Projection (DTO)
// ===============================

@Query("SELECT new com.example.employeemanagementsystem.projection.EmployeeDTO(e.id,e.name,e.email) FROM Employee e")
List<EmployeeDTO> getEmployeeDTO();
}
