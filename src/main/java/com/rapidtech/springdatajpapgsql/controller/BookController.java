package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.model.Book;
import com.rapidtech.springdatajpapgsql.model.Student;
import com.rapidtech.springdatajpapgsql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> get(){
        return bookService.getAllBook();
    }

    @PostMapping
    public Book post(@RequestBody Book book){
        return bookService.insertBook(book);
    }
}
