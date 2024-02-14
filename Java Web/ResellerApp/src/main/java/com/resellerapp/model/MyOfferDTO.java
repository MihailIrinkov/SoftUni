package com.resellerapp.model;

import com.resellerapp.model.emums.ConditionName;
import com.resellerapp.model.entity.Offer;

import java.math.BigDecimal;
import java.util.UUID;

public class MyOfferDTO {

    private ConditionName condition;

    private UUID id;

    private BigDecimal price;

    private String description;

//    public MyOfferDTO() {
//    }

    public MyOfferDTO(Offer offer) {
        this.condition = offer.getCondition().getName();
        this.price = offer.getPrice();
        this.description = offer.getDescription();
        id = offer.getId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
