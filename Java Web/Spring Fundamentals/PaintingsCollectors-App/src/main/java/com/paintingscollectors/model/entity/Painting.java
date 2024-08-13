package com.paintingscollectors.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Painting extends BaseEntity{

    @Column(nullable = false)
    @Length(min = 5, max = 40)
    private String name;

    @Column(nullable = false)
    @Length(min = 5, max = 30)
    private String author;

    @ManyToOne(optional = false)
    private Style style;

    @ManyToOne(optional = false)
    private User owner;

    @Length(max = 150)
    private String url;

    @Column(nullable = false)
    private String isFavorite;

    @Column(nullable = false)
    private int votes;

    public Painting() {
        isFavorite = "No";
    }

    public String getName() {
        return name;
    }

    public Painting setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Painting setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Style getStyle() {
        return style;
    }

    public Painting setStyle(Style style) {
        this.style = style;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public Painting setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Painting setUrl(String url) {
        this.url = url;
        return this;
    }


    public String getIsFavorite() {
        return isFavorite;
    }

    public Painting setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
        return this;
    }

    public int getVotes() {
        return votes;
    }

    public Painting setVotes(int votes) {
        this.votes = votes;
        return this;
    }

    public void vote() {
        votes = votes + 1;
    }
}
