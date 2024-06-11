package org.softuni.mobilele.repository;

import org.softuni.mobilele.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    Optional<Offer> findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

}
