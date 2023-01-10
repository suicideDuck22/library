package com.levelup.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "withdrawal")
public class WithdrawEntity {
    protected WithdrawEntity(){}

    public WithdrawEntity(UserEntity userId, int bookId, String withdrawDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.withdrawDate = withdrawDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotBlank(message = "Is mandatory inform the user making the withdraw.")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private UserEntity userId;

    @Column(nullable = false)
    @NotBlank(message = "Is mandatory inform the book being withdraw")
    private int bookId;

    @Column
    @NotBlank(message = "Date of the with draw is mandatory")
    private String withdrawDate;

    @Column
    private String returnDate;

    public Long getId() {
        return id;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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
