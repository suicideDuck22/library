package com.levelup.library.controllers;

import com.levelup.library.entities.BookEntity;
import com.levelup.library.services.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private ResponseEntity<Map<String, Collection<BookEntity>>> getAll(){
        Map<String, List<BookEntity>> books = new HashMap<>();
        books.put("books", bookService.getAllBooks());
        return new ResponseEntity(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<BookEntity> get(@PathVariable Long id){
        BookEntity book = bookService.getBook(id);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @PostMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Map<String, String>> insert(@RequestBody @Valid BookEntity book){
        Map<String, String> responseObject = new HashMap<>();
        bookService.insertBook(book);

        responseObject.put("message", "Book inserted successfully.");
        return new ResponseEntity(responseObject, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String, String>> remove(@PathVariable Long id){
        Map<String, String> responseObject = new HashMap<>();
        bookService.deleteBook(id);

        responseObject.put("message", "Book removed successfully.");
        return new ResponseEntity(responseObject, HttpStatus.OK);
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Map<String, String>> update(@PathVariable Long id, @RequestBody @Valid BookEntity updatedBook){
        Map<String, String> responseObject = new HashMap<>();
        bookService.updateBook(id, updatedBook);

        responseObject.put("message", "Book updated successfully.");
        return new ResponseEntity(responseObject, HttpStatus.OK);
    }

    @PutMapping("/withdraw/{id}")
    ResponseEntity<Map<String, String>> withdraw(@PathVariable Long id) {
        Map<String, String> resposeObject = new HashMap<>();
        bookService.withdrawBook(id);

        resposeObject.put("message", "Book withdrawed successfully");
        return new ResponseEntity(resposeObject, HttpStatus.OK);
    }
}
