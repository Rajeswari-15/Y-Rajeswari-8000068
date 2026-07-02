package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Hands-on 6
    @Transactional
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code : " + countryCode);
        }

        return result.get();
    }

    // Hands-on 7
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Hands-on 8
    @Transactional
    public void updateCountry(String code, String name)
            throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(code);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code : " + code);
        }

        Country country = result.get();

        country.setName(name);

        countryRepository.save(country);
    }

    // Hands-on 9
    @Transactional
    public void deleteCountry(String code) {

        countryRepository.deleteById(code);

    }

    // Search Countries
    public List<Country> searchCountry(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }

    // Get All Countries
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}