package com.cognizant.spring_learn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.exception.CountryNotFoundException;

@Service
public class CountryService {

    private ApplicationContext context =
            new ClassPathXmlApplicationContext("country.xml");

    public Country getCountry() {
        return context.getBean("country", Country.class);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Country> getAllCountries() {
        return (ArrayList<Country>) context.getBean("countryList");
    }

    public Country getCountry(String code) throws CountryNotFoundException {

        ArrayList<Country> countries = getAllCountries();

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        throw new CountryNotFoundException();
    }
}