package com.levelup.library.controllers;

import com.levelup.library.entities.BookEntity;
import com.levelup.library.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class Book {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/")
    private ResponseEntity<Map<String, Collection<BookEntity>>> getAllBooks(){
        Map<String, List<BookEntity>> books = new HashMap<>();
        books.put("books", bookService.getAllBooks());
        return new ResponseEntity(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<BookEntity> getBook(@PathVariable Long id){
        BookEntity book = bookService.getBook(id);
        return new ResponseEntity(book, HttpStatus.OK);
    }
}
