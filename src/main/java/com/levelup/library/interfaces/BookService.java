package com.levelup.library.interfaces;

import com.levelup.library.entities.BookEntity;

import java.util.Collection;

public interface BookService {
    Collection<BookEntity> getAllBooks();

    BookEntity getBook(Long id);

    void createBook(BookEntity newBook);

    void deleteBook(Long id);

    void updateBook(BookEntity updatedBook);
}
