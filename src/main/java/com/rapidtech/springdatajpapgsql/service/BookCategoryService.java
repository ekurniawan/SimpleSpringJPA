package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.dto.BookCategoryResDto;
import com.rapidtech.springdatajpapgsql.model.BookCategory;

import java.util.List;

public interface BookCategoryService {
    List<BookCategoryResDto> getAll();
    BookCategoryResDto getById(Long id);
    BookCategory insertBookCategory(BookCategory bookCategory);
    BookCategory updateBookCategory(Long id,BookCategory bookCategory);
    void deleteBookCategory(Long id);
}
