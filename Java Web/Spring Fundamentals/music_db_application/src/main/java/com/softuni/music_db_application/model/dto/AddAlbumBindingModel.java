package com.softuni.music_db_application.model.dto;

import com.softuni.music_db_application.model.entity.Artist;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddAlbumBindingModel {

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(min = 5)
    private String imgUrl;

    @NotBlank
    @Size(min = 5, message = "Description length must be more than 5 characters")
    private String description;

    @Min(value = 10)
    private Integer copies;

    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @PastOrPresent(message = "Release date cannot be in the future")
    private LocalDate releaseDate;

    private String producer;

    @NotEmpty(message ="You must select genre")
    private String genre;

    @NotNull(message = "You must select artist")
    private Artist artist;


    public AddAlbumBindingModel() {
    }

    public Artist getArtist() {
        return artist;
    }

    public AddAlbumBindingModel setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddAlbumBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public AddAlbumBindingModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddAlbumBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AddAlbumBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddAlbumBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AddAlbumBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AddAlbumBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public AddAlbumBindingModel setGenre(String genre) {
        this.genre = genre;
        return this;
    }
}
