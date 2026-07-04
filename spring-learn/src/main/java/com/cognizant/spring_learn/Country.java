package com.cognizant.spring_learn;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Country.class);

    @NotNull(message = "Country code cannot be null")
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    @NotNull(message = "Country name cannot be null")
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("setCode called");
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("setName called");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}