package com.softuni.music_db_application.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity{

    @Column(nullable = false)
    @Length(min = 3, max = 20)
    private String name;

    @Column(nullable = false)
    @Length(min = 5)
    private String imageUrl;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Length(min = 5)
    private String description;

    @Column
    @Min(value = 10)
    private Integer copies;

    @Column
    @Positive
    private BigDecimal price;

    @Column
    @PastOrPresent
    private LocalDate releasedDate;

    @Column
    private String producer;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private GenreName genre;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private User addedFrom;

    public Album() {
    }

    public String getName() {
        return name;
    }

    public Album setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Album setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Album setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public Album setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Album setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public Album setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public Album setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public GenreName getGenre() {
        return genre;
    }

    public Album setGenre(GenreName genre) {
        this.genre = genre;
        return this;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    public User getAddedFrom() {
        return addedFrom;
    }

    public Album setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
