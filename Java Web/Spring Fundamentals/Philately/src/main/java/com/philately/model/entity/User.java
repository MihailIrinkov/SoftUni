package com.philately.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Length(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
    @Length(min = 3, max = 20)
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String email;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Stamp> wishedStamps;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Stamp> purchasedStamps;

    public User() {
        wishedStamps = new HashSet<>();
        purchasedStamps = new HashSet<>();
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

    public Set<Stamp> getWishedStamps() {
        return wishedStamps;
    }

    public User setWishedStamps(Set<Stamp> wishedStamps) {
        this.wishedStamps = wishedStamps;
        return this;
    }

    public Set<Stamp> getPurchasedStamps() {
        return purchasedStamps;
    }

    public User setPurchasedStamps(Set<Stamp> purchasedStamps) {
        this.purchasedStamps = purchasedStamps;
        return this;
    }
}
