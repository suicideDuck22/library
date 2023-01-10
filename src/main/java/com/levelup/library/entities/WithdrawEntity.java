package com.levelup.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "withdrawal")
public class WithdrawEntity {
    protected WithdrawEntity(){}

    public WithdrawEntity(UserEntity user, BookEntity book, String withdrawDate) {
        this.user = user;
        this.book = book;
        this.withdrawDate = withdrawDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity book;

    @Column
    private String withdrawDate;

    @Column
    private String returnDate;

    public Long getId() {
        return id;
    }

    public UserEntity getUserId() {
        return user;
    }

    public void setUserId(UserEntity user) {
        this.user = user;
    }

    public BookEntity getBookId() {
        return book;
    }

    public void setBookId(int bookId) {
        this.book = book;
    }

    public String getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(String withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
