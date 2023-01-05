package com.levelup.library.services;

import com.levelup.library.entities.BookEntity;
import com.levelup.library.interfaces.BookService;

import java.util.Collection;

public class BookServiceImpl implements BookService {
    @Override
    public Collection<BookEntity> getAllBooks() {
        return null;
    }

    @Override
    public BookEntity getBook() {
        return null;
    }

    @Override
    public void createBook(BookEntity newBook) {

    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public void updateBook(BookEntity updatedBook) {

    }
}
