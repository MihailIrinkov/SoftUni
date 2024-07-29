package com.softuni.music_db_application.model.dto;

import com.softuni.music_db_application.model.entity.GenreName;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumDTO {

    private Long id;
    private String name;

    private String artist;

    private GenreName genre;

    private BigDecimal price;

    private LocalDate releaseDate;

    private int copies;

    private String imgUrl;

    public AlbumDTO() {
    }

    public Long getId() {
        return id;
    }

    public AlbumDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public AlbumDTO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public AlbumDTO setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public GenreName getGenre() {
        return genre;
    }

    public AlbumDTO setGenre(GenreName genre) {
        this.genre = genre;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public int getCopies() {
        return copies;
    }

    public AlbumDTO setCopies(int copies) {
        this.copies = copies;
        return this;
    }
}
