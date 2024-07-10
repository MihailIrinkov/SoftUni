package com.softuni.battleships.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Column(name = "user_name", nullable = false, unique = true)
    @Length(min = 3, max = 10)
    private String username;

    @Column(name = "full_name", nullable = false)
    @Length(min = 5, max = 20)
    private String fullName;

    @Column(nullable = false)
    @Length(min = 3)
    private String password;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
