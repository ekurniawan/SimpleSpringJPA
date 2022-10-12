package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.dto.BookCategoryResDto;
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
    public List<BookCategoryResDto> getAll() {
        List<BookCategory> bookCategories = bookCategoryRepository.findAll();
        List<BookCategoryResDto> bookCategoriesDto =
                bookCategories.stream().map(this::mapToProductResponse).toList();
        return bookCategoriesDto;
    }

    private BookCategoryResDto mapToProductResponse(BookCategory bookCategory) {
        return BookCategoryResDto.builder()
                .id(bookCategory.getId())
                .name(bookCategory.getName())
                .build();
    }

    @Override
    public BookCategoryResDto getById(Long id) {
        BookCategory bookCategory = bookCategoryRepository.findById(id).get();
        BookCategoryResDto bookCategoryResDto = mapToProductResponse(bookCategory);
        return bookCategoryResDto;
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
