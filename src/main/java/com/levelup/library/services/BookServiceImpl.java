package com.levelup.library.services;

import com.levelup.library.entities.BookEntity;
import com.levelup.library.interfaces.BookService;
import com.levelup.library.repositories.BookRepository;
import com.levelup.library.utils.Validator;
import jakarta.persistence.EntityManager;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookEntity> find(Integer booked) {
        if(booked == null){
            return bookRepository.findAll();
        }
        return bookRepository.findByStatus(booked);
    }

    @Override
    public BookEntity findById(Long id) {
        Optional<BookEntity> book = Optional.ofNullable(bookRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));

        return book.get();
    }

    @Override
    public void create(BookEntity newBook) {
        Validator.IsAValidDate(newBook.getPublishedAt());
        newBook.setBookStatus(BookEntity.AVAILABLE);
        bookRepository.save(newBook);
    }

    @Override
    public void delete(Long id) {
        Optional.ofNullable(bookRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("Book with ID " + id + " not founded.");
        }));

        bookRepository.deleteById(id);
    }

    @Override
    public void update(Long id, BookEntity updatedBook) {
        Optional.ofNullable(bookRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("Book with ID " + id + " not founded.");
        }));
        Validator.IsAValidDate(updatedBook.getPublishedAt());

        entityManager.merge(updatedBook);
    }
}
