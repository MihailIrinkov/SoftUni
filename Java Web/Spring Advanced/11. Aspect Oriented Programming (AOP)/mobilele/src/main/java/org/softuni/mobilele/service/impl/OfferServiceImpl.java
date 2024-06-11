package org.softuni.mobilele.service.impl;

import jakarta.transaction.Transactional;
import org.softuni.mobilele.enums.UserRoleEnum;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferDetailDTO;
import org.softuni.mobilele.model.dto.OfferSummaryDTO;
import org.softuni.mobilele.model.entity.Model;
import org.softuni.mobilele.model.entity.Offer;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.MonitoringService;
import org.softuni.mobilele.service.OfferService;
import org.softuni.mobilele.service.aop.WarnIfExecutionExceeds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final MonitoringService monitoringService;

    public OfferServiceImpl(OfferRepository offerRepository,
                            UserRepository userRepository,
                            ModelRepository modelRepository,
                            MonitoringService monitoringService) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.monitoringService = monitoringService;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO, UserDetails seller) {

        Offer newOffer = map(createOfferDTO);
        Model model = modelRepository.findById(createOfferDTO.getModelId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Model with " +
                                createOfferDTO.getModelId() + " not found!"));

        UserEntity sellerEntity = userRepository.findAllByEmail(seller.getUsername()).orElseThrow(() -> new UsernameNotFoundException(
                "User with email " + seller.getUsername() + " not found!"
        ));

        newOffer.setModel(model);
        newOffer.setSeller(sellerEntity);
        newOffer = offerRepository.save(newOffer);

        return newOffer.getUuid();
    }

    @WarnIfExecutionExceeds(timeInMillis = 1000)
    @Override
    public Page<OfferSummaryDTO> getAllOffers(Pageable pageable) {

        monitoringService.logOfferSearch();

        return offerRepository
                .findAll(pageable)
                .map(OfferServiceImpl::mapAsSummary);
    }

    @WarnIfExecutionExceeds(timeInMillis = 500)
    @Override
    public Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID, UserDetails viewer) {
        return offerRepository.findByUuid(offerUUID)
                .map(o -> this.mapAsDetails(o, viewer));
    }

    @Override
    @Transactional
    public void deleteOffer(UUID offerUuid) {
        offerRepository.deleteByUuid(offerUuid);
    }


    private OfferDetailDTO mapAsDetails(Offer offer, UserDetails viewer) {
        return new OfferDetailDTO(
                offer.getUuid().toString(),
                offer.getModel().getBrand().getName(),
                offer.getModel().getName(),
                offer.getYear(),
                offer.getMileage(),
                offer.getPrice(),
                offer.getEngine(),
                offer.getTransmission(),
                offer.getImageUrl(),
                offer.getSeller().getFirstName(),
                isOwner(offer, viewer != null ? viewer.getUsername() : null)
        );
    }

    @Override
    public boolean isOwner(UUID uuid, String username) {
        Offer offer = offerRepository.findByUuid(uuid).orElse(null);

        return isOwner(offer, username);
    }

    private boolean isOwner(Offer offer, String username) {
        if (offer == null || username == null) {
            return false;
        }

        UserEntity viewerEntity = userRepository.findAllByEmail(username)
                .orElseThrow(() -> new IllegalArgumentException("Unknown user..."));

        if (isAdmin(viewerEntity)) {
            return true;
        }

        return Objects.equals(offer.getSeller().getId(), viewerEntity.getId());
    }

    private boolean isAdmin(UserEntity userEntity) {
        return userEntity.getUserRole().stream().map(r -> r.getRole())
                .anyMatch(r -> UserRoleEnum.ADMIN == r);
    }

    private static OfferSummaryDTO mapAsSummary(Offer offer) {
        return new OfferSummaryDTO(
                offer.getUuid().toString(),
                offer.getModel().getBrand().getName(),
                offer.getModel().getName(),
                offer.getYear(),
                offer.getMileage(),
                offer.getPrice(),
                offer.getEngine(),
                offer.getTransmission(),
                offer.getImageUrl()
        );
    }

    private static Offer map(CreateOfferDTO createOfferDTO) {
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
