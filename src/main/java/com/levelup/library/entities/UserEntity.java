package com.levelup.library.entities;

import jakarta.persistence.*;

import java.sql.Date;

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
    private String name;
    @Column(length = 45)
    private String nickname;
    @Column(length = 11, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private Date birthDate;
    @Column(length = 14)
    private String phone;
    @Column(length = 45, nullable = false)
    private String email;
    @Column(length = 25, nullable = false)
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
