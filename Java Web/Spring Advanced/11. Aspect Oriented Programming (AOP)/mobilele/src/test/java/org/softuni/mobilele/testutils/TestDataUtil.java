package org.softuni.mobilele.testutils;

import org.softuni.mobilele.enums.Engine;
import org.softuni.mobilele.enums.Transmission;
import org.softuni.mobilele.enums.UserRoleEnum;
import org.softuni.mobilele.model.entity.*;
import org.softuni.mobilele.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class TestDataUtil {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private BrandRepository brandRepository;


    public void createExchangeRate(String currency, BigDecimal rate) {
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
        exchangeRateEntity.setCurrency(currency);
        exchangeRateEntity.setRate(rate);

        exchangeRateRepository.save(exchangeRateEntity);
    }

    public Offer createTestOffer(UserEntity owner) {


        Model model = new Model();
        model.setName("Test_Model");
        Model model1 = new Model();
        model1.setName("Test_Model1");

        Brand brand = new Brand();
        brand.setName("Test_Brand");
        brand.setModels(
                List.of(
                        model, model1
                )
        );

                brandRepository.save(brand);

        Offer offer = new Offer();
        offer.setModel(brand.getModels().get(0));
        offer.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/413px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        offer.setPrice(BigDecimal.valueOf(1000));
        offer.setYear(2002);
        offer.setUuid(UUID.randomUUID());
        offer.setDescription("Test Description");
        offer.setEngine(Engine.DIESEL);
        offer.setMileage(10000);
        offer.setTransmission(Transmission.AUTOMATIC);
        offer.setSeller(owner);

        return offerRepository.save(offer);

    }

    public void cleanUp() {
        exchangeRateRepository.deleteAll();
        offerRepository.deleteAll();
        brandRepository.deleteAll();
    }
}
