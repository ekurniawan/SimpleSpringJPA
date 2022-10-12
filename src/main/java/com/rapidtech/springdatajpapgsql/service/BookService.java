package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.BookResDto;
import com.rapidtech.springdatajpapgsql.model.Book;

import java.util.List;

public interface BookService {
    List<BookResDto> getAllBook();
    BookResDto getBookById(Long id);
    Book insertBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);
}
