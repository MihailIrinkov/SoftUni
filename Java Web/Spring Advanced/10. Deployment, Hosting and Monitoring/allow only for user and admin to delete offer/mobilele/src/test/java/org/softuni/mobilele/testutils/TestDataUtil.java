package org.softuni.mobilele.testutils;

import org.softuni.mobilele.enums.UserRoleEnum;
import org.softuni.mobilele.model.entity.ExchangeRateEntity;
import org.softuni.mobilele.model.entity.Offer;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.ExchangeRateRepository;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class TestDataUtil {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private OfferRepository offerRepository;

    public void createExchangeRate(String currency, BigDecimal rate) {
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
        exchangeRateEntity.setCurrency(currency);
        exchangeRateEntity.setRate(rate);

        exchangeRateRepository.save(exchangeRateEntity);
    }

    public Offer createTestOffer(UserEntity owner) {

    }

    public void cleanAllTestData() {
        exchangeRateRepository.deleteAll();
    }
}
