package com.philately.model.dto;

import com.philately.model.entity.PaperName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AddStampBindingModel {

    @NotBlank
    @Size(min = 5, max = 20, message = "Name length must be between 5 and 20 characters!")
    private String name;

    @NotBlank
    @Size(min = 5, max = 25, message = "Description length must be between 3 and 25 characters!")
    private String description;

    @NotNull(message = "You must select a type of paper!")
    private PaperName paper;

    @NotNull
    @Positive
    private int price;

    @NotBlank(message = "Please enter valid image URL!")
    @Size(max = 150, message = "Please enter valid image URL!")
    private String imageUrl;

    public AddStampBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AddStampBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddStampBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public PaperName getPaper() {
        return paper;
    }

    public AddStampBindingModel setPaper(PaperName paper) {
        this.paper = paper;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public AddStampBindingModel setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddStampBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
