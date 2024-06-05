package org.softuni.mobilele.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRateEntity {

    @Id
    @NotNull
    private String currency;

    @NotNull
    private BigDecimal rate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
//    public ExchangeRateEntity setRate(BigDecimal rate) {
//        this.rate = rate;
//        return this;
//    }
}
