package softuni.bg.jsoncardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.jsoncardealer.domain.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
