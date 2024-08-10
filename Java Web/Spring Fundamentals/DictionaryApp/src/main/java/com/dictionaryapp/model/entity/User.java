package com.dictionaryapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
    @Length(min = 3, max = 20)
    private String password;

    @Column(unique = true, nullable = true)
    @Email
    private String email;

    @OneToMany
    private List<Word> addedWords;

    public User() {
        addedWords = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
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

    public List<Word> getAddedWords() {
        return addedWords;
    }

    public User setAddedWords(List<Word> addedWords) {
        this.addedWords = addedWords;
        return this;
    }
}
