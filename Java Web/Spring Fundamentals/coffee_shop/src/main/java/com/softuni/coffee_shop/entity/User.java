package com.softuni.coffee_shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name= "users")
public class User extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Length(min = 5, max = 20)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(nullable = false)
    @Length(min = 5, max = 20)
    private String lastName;

    @Column(nullable = false)
    @Length(min = 3)
    private String password;

    @Column(unique = true, nullable = false)
    @Email
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

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String passwor) {
        this.password = passwor;
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
