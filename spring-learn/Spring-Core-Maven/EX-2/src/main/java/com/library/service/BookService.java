package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {

        System.out.println("Book Service Started");

        bookRepository.getBookDetails();

        System.out.println("Book details displayed successfully.");

    }

}