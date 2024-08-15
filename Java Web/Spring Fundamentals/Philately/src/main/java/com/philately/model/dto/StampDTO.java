package com.philately.model.dto;

import com.philately.model.entity.PaperName;

public class StampDTO {

    private Long id;

    private String ownerName;
    private String name;

    private PaperName paperName;

    private int price;

    private String description;

    private String imageUrl;

    public StampDTO() {
    }

    public String getOwnerName() {
        return ownerName;
    }

    public StampDTO setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public StampDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public StampDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public StampDTO setName(String name) {
        this.name = name;
        return this;
    }

    public PaperName getPaperName() {
        return paperName;
    }

    public StampDTO setPaperName(PaperName paperName) {
        this.paperName = paperName;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public StampDTO setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StampDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
