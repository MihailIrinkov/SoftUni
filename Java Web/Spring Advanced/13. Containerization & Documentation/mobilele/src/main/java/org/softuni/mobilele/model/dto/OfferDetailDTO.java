package org.softuni.mobilele.model.dto;

import org.softuni.mobilele.enums.Engine;
import org.softuni.mobilele.enums.Transmission;

import java.math.BigDecimal;

public record OfferDetailDTO (
        String id,
        String brand,
        String model,
        int year,
        int mileage,
        BigDecimal price,
        Engine engine,
        Transmission transmission,
        String imageUrl,
        String seller,
        boolean viewerIsOwner
) {

    public String summary() {
        return brand + " " + model + ", " + year;
    }
}
