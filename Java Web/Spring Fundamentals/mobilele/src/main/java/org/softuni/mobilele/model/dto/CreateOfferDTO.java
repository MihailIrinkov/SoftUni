package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.*;
import org.softuni.mobilele.enums.Engine;
import org.softuni.mobilele.enums.Transmission;
import org.softuni.mobilele.model.entity.Model;
import org.softuni.mobilele.model.validation.YearNotInTheFuture;

public class CreateOfferDTO {

    @NotEmpty
    @Size(min = 5, max = 512)
    private String description;

    @Positive
    @NotNull
    private Long modelId;

    @NotNull
    private Engine engine;

    @NotNull
    private Transmission transmission;

    @NotEmpty
    private String imageUrl;

    @Positive
    @NotNull
    private Integer mileage;

    @Positive
    @NotNull
    private Integer price;

    @NotNull(message = "Year must be provided")
    @Min(1930)
    @YearNotInTheFuture(message = "The Year must not be in the future!")
    private Integer year;

    public CreateOfferDTO() {
    }

    public CreateOfferDTO(String description, Long modelId, Engine engine, Transmission transmission, String imageUrl, Integer mileage, Integer price, Integer year) {
        this.description = description;
        this.modelId = modelId;
        this.engine = engine;
        this.transmission = transmission;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
