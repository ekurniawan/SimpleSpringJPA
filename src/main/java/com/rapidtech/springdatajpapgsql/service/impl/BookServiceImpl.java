package com.rapidtech.springdatajpapgsql.service.impl;

import com.rapidtech.springdatajpapgsql.dto.BookResDto;
import com.rapidtech.springdatajpapgsql.model.Book;
import com.rapidtech.springdatajpapgsql.repository.BookRepository;
import com.rapidtech.springdatajpapgsql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookResDto> getAllBook() {
        List<BookResDto> booksDto = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for(Book book : books){
            booksDto.add(new BookResDto(book.getId(),book.getTitle(),book.getWriter(),
                    book.getIsbn()));
        }
        return booksDto;
    }

    @Override
    public BookResDto getBookById(Long id) {
        BookResDto bookResDto = new BookResDto();
        Book book = bookRepository.findById(id).orElse(new Book());
        bookResDto.setId(book.getId());
        bookResDto.setTitle(book.getTitle());
        bookResDto.setWriter(book.getWriter());
        bookResDto.setIsbn(book.getIsbn());

        return bookResDto;
    }

    @Override
    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
