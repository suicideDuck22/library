package com.levelup.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;

@Validated
@Entity
@Table(name = "person")
public class UserEntity {

    protected UserEntity(){}

    public UserEntity(String name, String nickname, String cpf, Date birthDate, String phone, String email, String password) {
        this.name = name;
        this.nickname = nickname;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(length = 45, nullable = false)
    @NotBlank(message = "Name is mandatory.")
    private String name;
    @Column(length = 45)
    private String nickname;
    @Column(length = 11, nullable = false)
    @Min(value = 11, message = "CPF need to have a min length of 11 characters.")
    @Max(value = 11, message = "CPF need to have a max length of 11 characters.")
    @NotBlank(message = "CPF is mandatory.")
    private String cpf;
    @Column(nullable = false)
//    @NotBlank(message = "Birth Date is mandatory.")
    private Date birthDate;
    @Column(length = 14)
    private String phone;
    @Column(length = 45, nullable = false)
    @NotBlank(message = "Email is mandatory.")
    @Email(message = "Email need contain dot and @")
    private String email;
    @Column(length = 64, nullable = false)
    @NotBlank(message = "Password is mandatory.")
    private String password;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, name=%s, nickname=%s]",
                id, name, nickname
        );
    }

}
