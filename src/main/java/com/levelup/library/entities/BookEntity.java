package com.levelup.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;

@Validated
@Entity
@Table(name = "book")
public class BookEntity {
    protected BookEntity(){}

    public BookEntity(String title, String synopsis, String authorName, String publishedAt, String publisher, BookStatus bookStatus) {
        this.title = title;
        this.synopsis = synopsis;
        this.authorName = authorName;
        this.publishedAt = publishedAt;
        this.publisher = publisher;
        this.bookStatus = bookStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title is mandatory.")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Synopsis is mandatory.")
    private String synopsis;

    @Column(nullable = false)
    @NotBlank(message = "Author Name is mandatory.")
    private String authorName;

    @Column(nullable = false)
    private String publishedAt;

    @Column(nullable = false)
    @NotBlank(message = "Publisher is mandatory.")
    private String publisher;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private BookStatus bookStatus;

    public enum BookStatus {
        UNAVAILABLE, AVAILABLE;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
