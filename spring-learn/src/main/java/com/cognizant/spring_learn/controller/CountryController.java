package com.cognizant.spring_learn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.exception.CountryNotFoundException;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START");
        Country country = countryService.getCountry();
        LOGGER.info("END");
        return country;
    }

    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START");
        ArrayList<Country> list = countryService.getAllCountries();
        LOGGER.info("END");
        return list;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code)
            throws CountryNotFoundException {

        LOGGER.info("START");
        Country country = countryService.getCountry(code);
        LOGGER.info("END");
        return country;
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody @jakarta.validation.Valid Country country) {
        LOGGER.info("START POST");
        LOGGER.info("Country: {}", country);
        return country;
    }
}