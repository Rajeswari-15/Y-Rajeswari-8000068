package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void getBookDetails() {

        System.out.println("BookRepository: Fetching book details from database.");

    }

}