package com.levelup.library.entities;

import com.levelup.library.entities.UserEntity;
import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;

@Validated
@Entity
@Table(name = "book")
public class BookEntity {
    protected BookEntity(){}

    public BookEntity(String title, String synopsis, String authorName, Date publishedAt, String publisher, BookStatus bookStatus) {
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
    private String title;

    @Column(nullable = false)
    private String synopsis;

    @Column(nullable = false)
    private String authorName;

    @Column(nullable = false)
    private Date publishedAt;

    @Column(nullable = false)
    private String publisher;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private BookStatus bookStatus;

    private enum BookStatus {
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

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
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
