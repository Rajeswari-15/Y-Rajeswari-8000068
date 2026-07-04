package com.cognizant.orm_learn_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn_final.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Hands-on 5
    List<Country> findByNameContainingIgnoreCase(String name);

    // Query Method 1
    List<Country> findByNameContaining(String text);

    // Query Method 2
    List<Country> findByNameContainingOrderByNameAsc(String text);

    // Query Method 3
    List<Country> findByNameStartingWith(String alphabet);

}