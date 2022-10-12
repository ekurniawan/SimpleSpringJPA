package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.dto.BookResDto;
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
    public List<BookResDto> get(){
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public BookResDto getbyid(@PathVariable("id") Long id)
    {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book post(@RequestBody Book book){
        return bookService.insertBook(book);
    }

    @PutMapping
    public Book put(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "Data id:"+ id.toString() +" berhasil di delete";
    }
}
