package com.levelup.library.interfaces;

import com.levelup.library.entities.BookEntity;

import java.util.Collection;

public interface BookService {
    Collection<BookEntity> getAllBooks();

    BookEntity getBook(Long id);

    void insertBook(BookEntity newBook);

    void deleteBook(Long id);

    void updateBook(Long id, BookEntity updatedBook);

    void withdrawBook(Long id);
}
