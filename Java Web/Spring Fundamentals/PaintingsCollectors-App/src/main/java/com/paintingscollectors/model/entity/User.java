package com.paintingscollectors.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class User extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Length(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
    @Length(min = 3, max = 20)
    private String password;

    @Email
    private String email;

    @OneToMany
    private List<Painting> paintings;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Painting> favoritePaintings;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Painting> ratedPaintings;

    public User() {
        paintings = new ArrayList<>();
        favoritePaintings = new HashSet<>();
        ratedPaintings = new HashSet<>();
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

    public List<Painting> getPaintings() {
        return paintings;
    }

    public User setPaintings(List<Painting> paintings) {
        this.paintings = paintings;
        return this;
    }

    public Set<Painting> getFavoritePaintings() {
        return favoritePaintings;
    }

    public User setFavoritePaintings(Set<Painting> favoritePaintings) {
        this.favoritePaintings = favoritePaintings;
        return this;
    }

    public Set<Painting> getRatedPaintings() {
        return ratedPaintings;
    }

    public User setRatedPaintings(Set<Painting> ratedPaintings) {
        this.ratedPaintings = ratedPaintings;
        return this;
    }
}
