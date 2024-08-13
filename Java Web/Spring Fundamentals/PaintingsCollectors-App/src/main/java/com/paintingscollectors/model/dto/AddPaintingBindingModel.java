package com.paintingscollectors.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddPaintingBindingModel {

    @NotBlank
    @Size(min = 5, max = 40)
    private String name;

    @NotBlank
    @Size(min = 5, max = 30)
    private String author;

    @Size(max = 150, message = "Please enter valid URL!")
    @NotBlank
    private String url;

    @NotBlank
    private String style;

    public String getName() {
        return name;
    }

    public AddPaintingBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public AddPaintingBindingModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public AddPaintingBindingModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public AddPaintingBindingModel setStyle(String style) {
        this.style = style;
        return this;
    }
}
