package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    Book getBookById(Long id);
    Book insertBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);
}
