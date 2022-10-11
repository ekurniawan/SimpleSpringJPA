package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.model.Book;
import com.rapidtech.springdatajpapgsql.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/book")
@RestController
public class BookController {

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id")Long id){
        Book book1 = new Book();
        book1.setId(id);
        book1.setTitle("Spring Boot in Action");
        book1.setWriter("Erick");
        book1.setIsbn("ISBN-99883344");
        return book1;
    }

    @GetMapping("/bytitle")
    public String getBooksByTitle(@RequestParam(name = "title") String title){
        return "book by title: "+title;
    }

    @GetMapping
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Spring in Action","Erick Kurniawan","ISBN-99887766"));
        books.add(new Book("Java Fundamentals","Budi Sutejo","ISBN 998877665"));
        books.add(new Book("JPA in Action","Scott Gu","ISBN-99887766"));
        return books;
    }

    @PostMapping
    public Book Post(@RequestBody Book book){
        return book;
    }
}
