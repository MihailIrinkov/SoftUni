package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.entity.Model;
import org.softuni.mobilele.model.entity.Offer;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        Offer newOffer = map(createOfferDTO);
        Model model = modelRepository.findById(createOfferDTO.getModelId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Model with " +
                                createOfferDTO.getModelId() + " not found!"));

        newOffer.setModel(model);

        newOffer = offerRepository.save(newOffer);

        return newOffer.getUuid();
    }

    private Offer map(CreateOfferDTO createOfferDTO) {
        Offer offer = new Offer();
        offer.setUuid(UUID.randomUUID());
        offer.setDescription(createOfferDTO.getDescription());
        offer.setEngine(createOfferDTO.getEngine());
        offer.setTransmission(createOfferDTO.getTransmission());
        offer.setImageUrl(createOfferDTO.getImageUrl());
        offer.setMileage(createOfferDTO.getMileage());
        offer.setPrice(BigDecimal.valueOf(createOfferDTO.getPrice()));
        offer.setYear(createOfferDTO.getYear());

        return offer;
    }
}
