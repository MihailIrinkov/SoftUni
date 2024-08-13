package com.paintingscollectors.model.dto;

import com.paintingscollectors.model.entity.Style;

public class PaintingDTO {

    private Long id;

    private String name;

    private String author;

    private String style;

    private String url;

    private String owner;

    private int votes;

    public PaintingDTO() {
    }

    public String getOwner() {
        return owner;
    }

    public int getVotes() {
        return votes;
    }

    public PaintingDTO setVotes(int votes) {
        this.votes = votes;
        return this;
    }

    public PaintingDTO setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public Long getId() {
        return id;
    }

    public PaintingDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaintingDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public PaintingDTO setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public PaintingDTO setStyle(String style) {
        this.style = style;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PaintingDTO setUrl(String url) {
        this.url = url;
        return this;
    }
}
