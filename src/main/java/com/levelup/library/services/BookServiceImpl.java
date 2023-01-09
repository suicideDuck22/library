package com.levelup.library.services;

import com.levelup.library.entities.BookEntity;
import com.levelup.library.interfaces.BookService;
import com.levelup.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookEntity> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return books;
    }

    @Override
    public BookEntity getBook(Long id) {
        Optional<BookEntity> book = Optional.ofNullable(bookRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));

        return book.get();
    }

    @Override
    public void insertBook(BookEntity newBook) {
        bookRepository.save(newBook);
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public void updateBook(Long id, BookEntity updatedBook) {

    }

    @Override
    public void withdrawBook(Long id){

    }
}
