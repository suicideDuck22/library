package com.levelup.library.interfaces;

import com.levelup.library.entities.BookEntity;

import java.util.Collection;
import java.util.List;

public interface BookService {

    List<BookEntity> find(Integer booked);

    BookEntity findById(Long id);

    void create(BookEntity newBook);

    void delete(Long id);

    void update(Long id, BookEntity updatedBook);

    String returnOrWithdraw(Long bookId, Long userId, Integer status);
}
