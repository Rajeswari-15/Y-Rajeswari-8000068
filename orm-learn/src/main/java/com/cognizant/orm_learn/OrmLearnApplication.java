package com.cognizant.orm_learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        getCountryTest();

        testAddCountry();

        testUpdateCountry();

        testDeleteCountry();

    }

    // Hands-on 6
    private void getCountryTest() {

        System.out.println("\n========== Hands-on 6 ==========");

        try {

            Country country = countryService.findCountryByCode("IN");

            System.out.println(country);

        } catch (CountryNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }

    // Hands-on 7
    private void testAddCountry() {

        System.out.println("\n========== Hands-on 7 ==========");

        try {

            Country country = new Country("XX", "ChatGPTLand");

            countryService.addCountry(country);

            System.out.println("Country Added Successfully");

            System.out.println(countryService.findCountryByCode("XX"));

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // Hands-on 8
    private void testUpdateCountry() {

        System.out.println("\n========== Hands-on 8 ==========");

        try {

            countryService.updateCountry("XX", "OpenAILand");

            System.out.println(countryService.findCountryByCode("XX"));

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    // Hands-on 9
    private void testDeleteCountry() {

        System.out.println("\n========== Hands-on 9 ==========");

        countryService.deleteCountry("XX");

        try {

            System.out.println(countryService.findCountryByCode("XX"));

        } catch (Exception e) {

            System.out.println("Country Deleted Successfully");

        }

    }

}