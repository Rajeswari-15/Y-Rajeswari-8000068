package com.cognizant.orm_learn_final;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn_final.model.Country;
import com.cognizant.orm_learn_final.model.Department;
import com.cognizant.orm_learn_final.model.Employee;
import com.cognizant.orm_learn_final.model.Skill;
import com.cognizant.orm_learn_final.model.Stock;
import com.cognizant.orm_learn_final.repository.StockRepository;
import com.cognizant.orm_learn_final.service.CountryService;
import com.cognizant.orm_learn_final.service.DepartmentService;
import com.cognizant.orm_learn_final.service.EmployeeService;
import com.cognizant.orm_learn_final.service.SkillService;
import com.cognizant.orm_learn_final.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnFinalApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnFinalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //=========================
        // COUNTRY CRUD
        //=========================

        //getCountryByCodeTest();
        //addCountryTest();
        //updateCountryTest();
        //deleteCountryTest();

        //=========================
        // COUNTRY QUERY METHODS
        //=========================

        //searchContainingTest();
        //searchContainingSortedTest();
        //searchStartingWithTest();

        //=========================
        // STOCK QUERY METHODS
        //=========================

        //testFacebookStocks();
        //testGoogleStocks();
        //testHighestVolume();
        //testNetflixLowest();

        //=========================
        // MANY TO ONE
        //=========================

        //testGetEmployee();
        //testAddEmployee();
        //testUpdateEmployee();

        //=========================
        // ONE TO MANY
        //=========================

        //testGetDepartment();

        //=========================
        // MANY TO MANY
        //=========================

        testAddSkillToEmployee();

    }

    //======================================================
    // COUNTRY
    //======================================================

    private void getCountryByCodeTest() {

        try {
            System.out.println(countryService.findCountryByCode("IN"));
        } catch (CountryNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void addCountryTest() {

        Country country = new Country("AA", "ChatGPT Country");

        countryService.addCountry(country);

        try {
            System.out.println(countryService.findCountryByCode("AA"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updateCountryTest() {

        try {

            countryService.updateCountry("IN", "India Updated");

            System.out.println(countryService.findCountryByCode("IN"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void deleteCountryTest() {

        countryService.deleteCountry("AA");

        System.out.println("Deleted Successfully");

    }

    private void searchContainingTest() {

        List<Country> countries =
                countryService.searchCountries("ou");

        countries.forEach(System.out::println);

    }

    private void searchContainingSortedTest() {

        List<Country> countries =
                countryService.searchCountriesSorted("ou");

        countries.forEach(System.out::println);

    }

    private void searchStartingWithTest() {

        List<Country> countries =
                countryService.searchCountriesStartingWith("Z");

        countries.forEach(System.out::println);

    }

    //======================================================
    // STOCK
    //======================================================

    private void testFacebookStocks() {

        stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019,9,1),
                LocalDate.of(2019,9,30))
                .forEach(System.out::println);

    }

    private void testGoogleStocks() {

        stockRepository.findByCodeAndCloseGreaterThan(
                "GOOGL",
                1250)
                .forEach(System.out::println);

    }

    private void testHighestVolume() {

        stockRepository.findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);

    }

    private void testNetflixLowest() {

        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);

    }

    //======================================================
    // MANY TO ONE
    //======================================================

    private void testGetEmployee() {

        Employee employee = employeeService.get(1);

        System.out.println(employee);

        System.out.println(employee.getDepartment());

        System.out.println(employee.getSkillList());

    }

    private void testAddEmployee() throws Exception {

        Employee employee = new Employee();

        employee.setName("Rajeshwari");

        employee.setSalary(65000);

        employee.setPermanent(true);

        employee.setDateOfBirth(
                new SimpleDateFormat("dd/MM/yyyy")
                        .parse("15/08/2002"));

        Department department = departmentService.get(2);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);

    }

    private void testUpdateEmployee() {

        Employee employee = employeeService.get(1);

        Department department = departmentService.get(2);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);

    }

    //======================================================
    // ONE TO MANY
    //======================================================

    private void testGetDepartment() {

        Department department = departmentService.get(1);

        System.out.println(department);

        System.out.println(department.getEmployeeList());

    }

    //======================================================
    // MANY TO MANY
    //======================================================

    private void testAddSkillToEmployee() {

        Employee employee = employeeService.get(1);

        Skill skill = skillService.get(2);

        employee.getSkillList().add(skill);

        employeeService.save(employee);

        System.out.println(employee);

        System.out.println(employee.getSkillList());

    }

}