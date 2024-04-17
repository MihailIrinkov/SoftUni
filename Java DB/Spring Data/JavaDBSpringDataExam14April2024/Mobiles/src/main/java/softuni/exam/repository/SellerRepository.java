package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Seller;

import java.util.Optional;

//TODO
@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {


    Optional<Seller> findAllByLastName(String lastName);

    Optional<Seller> findById(Long id);
}
