package com.cognizant.orm_learn_final.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn_final.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Facebook September 2019
    List<Stock> findByCodeAndDateBetween(
            String code,
            LocalDate start,
            LocalDate end);

    // Google Close > 1250
    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            double close);

    // Top 3 Highest Volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Top 3 Lowest Netflix Close
    List<Stock> findTop3ByCodeOrderByCloseAsc(
            String code);

}