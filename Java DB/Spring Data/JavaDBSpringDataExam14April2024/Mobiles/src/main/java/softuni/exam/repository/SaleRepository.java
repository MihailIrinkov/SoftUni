package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Sale;

import java.util.Optional;

//TODO
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {


    Optional<Sale> findAllByNumber(String number);

}
