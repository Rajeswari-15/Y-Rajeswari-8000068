package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

        System.out.println("Constructor Injection Executed");

    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

        System.out.println("Setter Injection Executed");

    }

    public void displayBook() {

        System.out.println("BookService: Processing request...");

        bookRepository.getBookDetails();

        System.out.println("BookService: Request completed.");

    }

}