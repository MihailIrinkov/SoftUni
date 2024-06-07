package org.softuni.mobilele.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.softuni.mobilele.model.dto.ExchangeRatesDTO;
import org.softuni.mobilele.model.entity.ExchangeRateEntity;
import org.softuni.mobilele.repository.ExchangeRateRepository;
import org.softuni.mobilele.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class CurrencyServiceImplTestIT {

    @Autowired
    private CurrencyService currencyServiceToTest;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @BeforeEach
    void setUp() {
        exchangeRateRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        exchangeRateRepository.deleteAll();
    }

    @Test
    void refreshRates() {
    }


    @Test
    void test_BGN_TO_USD() {
        var testExRates =
                new ExchangeRatesDTO("USD", Map.of("BGN", BigDecimal.valueOf(1.840515)));
        currencyServiceToTest.refreshRates(testExRates);
        Optional<ExchangeRateEntity> exRateUSD_BGN =
                exchangeRateRepository.findById("USD");

        assertTrue(exRateUSD_BGN.isPresent());
        assertEquals(BigDecimal.valueOf(0.54),
                exRateUSD_BGN.map(ExchangeRateEntity::getRate).orElse(null));
    }

    @ParameterizedTest(name = "Conversion BGN/EUR exRateBGN {0}, exRateEUR {1}, expected = 2")
    @MethodSource("test_Data_BGN_TO_EUR")
    void test_BGN_TO_EUR(Double exchangeRateBGN,
                         Double exchangeRateEUR,
                         Double expectedValue) {
        var testExRate =
                new ExchangeRatesDTO("USD",
                        Map.of("BGN", BigDecimal.valueOf(exchangeRateBGN),
                                "EUR", BigDecimal.valueOf(exchangeRateEUR)));

        currencyServiceToTest.refreshRates(testExRate);
        Optional<ExchangeRateEntity> exRate = exchangeRateRepository.findById("EUR");

        Assertions.assertTrue(exRate.isPresent());
        Assertions.assertEquals(BigDecimal.valueOf(expectedValue).setScale(2, RoundingMode.DOWN),
                exRate.map(ExchangeRateEntity::getRate).orElseThrow());
    }

    private static Stream<Arguments> test_Data_BGN_TO_EUR() {
        return Stream.of(
                Arguments.of(1.840515, 0.937668, 0.51),
                Arguments.of(1.777515, 0.544454, 0.31),
                Arguments.of(1.0, 1.0, 1.0)
        );
    }

}