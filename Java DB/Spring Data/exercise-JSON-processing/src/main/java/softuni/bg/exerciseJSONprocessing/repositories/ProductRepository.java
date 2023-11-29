package softuni.bg.exerciseJSONprocessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.exerciseJSONprocessing.domain.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(
            BigDecimal lowBoundary, BigDecimal highBoundary);

}
