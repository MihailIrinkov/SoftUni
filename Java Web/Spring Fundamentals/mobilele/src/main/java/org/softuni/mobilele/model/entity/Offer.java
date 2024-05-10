package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.JdbcTypeCode;
import org.softuni.mobilele.enums.Engine;
import org.softuni.mobilele.enums.Transmission;
import org.softuni.mobilele.model.validation.YearNotInTheFuture;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @NotNull
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    @Column
    @NotEmpty
    private String description;

    @NotNull
    @ManyToOne
    private Model model;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Engine engine;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @NotEmpty
    @Column
    private String imageUrl;

    @Column
    @Positive
    private Integer mileage;

    @NotNull
    @Column
    private BigDecimal price;

    @Column
    @Min(1930)
    @NotNull
    private Integer year;

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
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

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
