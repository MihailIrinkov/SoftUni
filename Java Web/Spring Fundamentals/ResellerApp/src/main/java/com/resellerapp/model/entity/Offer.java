package com.resellerapp.model.entity;

import com.resellerapp.model.OfferCreateBindingModel;
import jdk.jfr.Description;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @NotNull
    @Length(min = 2, max = 50)
    private String description;

    @NotNull
    @Min(value = 0)
    private BigDecimal price;

    @ManyToOne
    @NotNull
    private Condition condition;

    @ManyToOne
    @NotNull
    private User createdBy;

    @ManyToOne
    private User boughtBy;

    public Offer() {
    }

    public Offer(OfferCreateBindingModel offerCreateBindingModel,
                 Condition condition, User createdBy) {
        description = offerCreateBindingModel.getDescription();
        price = offerCreateBindingModel.getPrice();
        this.condition = condition;
        this.createdBy = createdBy;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(User boughtBy) {
        this.boughtBy = boughtBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
