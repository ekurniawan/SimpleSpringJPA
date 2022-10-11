package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.model.BookCategory;

import java.util.List;

public interface BookCategoryService {
    List<BookCategory> getAll();
    BookCategory getById(Long id);
    BookCategory insertBookCategory(BookCategory bookCategory);
    BookCategory updateBookCategory(Long id,BookCategory bookCategory);
    void deleteBookCategory(Long id);
}
