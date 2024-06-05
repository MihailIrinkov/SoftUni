package org.softuni.mobilele.testutils;

import org.softuni.mobilele.model.entity.ExchangeRateEntity;
import org.softuni.mobilele.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TestData {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public void createExchangeRate(String currency, BigDecimal rate) {
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
        exchangeRateEntity.setCurrency(currency);
        exchangeRateEntity.setRate(rate);

        exchangeRateRepository.save(exchangeRateEntity);
    }

    public void cleanAllTestData() {
        exchangeRateRepository.deleteAll();
    }
}
