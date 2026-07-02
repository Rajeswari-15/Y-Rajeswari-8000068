package com.cognizant.orm_learn_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn_final.model.Country;
import com.cognizant.orm_learn_final.repository.CountryRepository;
import com.cognizant.orm_learn_final.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Find all countries
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Find by code
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found : " + countryCode);
        }

        return result.get();
    }

    // Add
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Update
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {

        Country country = findCountryByCode(code);

        country.setName(name);

        countryRepository.save(country);
    }

    // Delete
    @Transactional
    public void deleteCountry(String code) {

        countryRepository.deleteById(code);
    }

    // Query Method 1
    @Transactional
    public List<Country> searchCountries(String text) {

        return countryRepository.findByNameContaining(text);
    }

    // Query Method 2
    @Transactional
    public List<Country> searchCountriesSorted(String text) {

        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    // Query Method 3
    @Transactional
    public List<Country> searchCountriesStartingWith(String alphabet) {

        return countryRepository.findByNameStartingWith(alphabet);
    }

}