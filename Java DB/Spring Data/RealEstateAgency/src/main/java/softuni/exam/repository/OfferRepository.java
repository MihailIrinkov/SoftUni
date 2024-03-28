package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;

import java.util.List;

// TODO:
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o WHERE o.apartment.apartmentType = 'three_rooms' " +
            "ORDER BY o.apartment.area DESC, o.price")
    List<Offer> findAllBy(ApartmentType apartmentType);

    List<Offer> findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc
            (ApartmentType apartmentType);
}
