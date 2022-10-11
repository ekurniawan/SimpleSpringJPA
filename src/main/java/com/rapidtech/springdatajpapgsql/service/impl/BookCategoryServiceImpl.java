package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.model.BookCategory;
import com.rapidtech.springdatajpapgsql.repository.BookCategoryRepository;
import com.rapidtech.springdatajpapgsql.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategory> getAll() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory getById(Long id) {
        return bookCategoryRepository.findById(id).get();
    }

    @Override
    public BookCategory insertBookCategory(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    @Override
    public BookCategory updateBookCategory(Long id, BookCategory bookCategory) {
        Optional<BookCategory> editCatOpt = bookCategoryRepository.findById(id);
        BookCategory editCat = new BookCategory();
        if(editCatOpt.isPresent()){
            editCat = editCatOpt.get();
            editCat.setName(bookCategory.getName());
            bookCategoryRepository.save(editCat);
        }
        return editCat;
    }

    @Override
    public void deleteBookCategory(Long id) {
        BookCategory delBook = bookCategoryRepository.findById(id).orElse(new BookCategory());
        bookCategoryRepository.delete(delBook);
    }
}
