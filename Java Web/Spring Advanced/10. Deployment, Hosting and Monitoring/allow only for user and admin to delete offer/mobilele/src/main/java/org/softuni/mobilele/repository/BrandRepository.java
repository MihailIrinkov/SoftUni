package org.softuni.mobilele.repository;

import org.softuni.mobilele.model.entity.Brand;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

//    @Query("SELECT b FROM Brand b JOIN FETCH b.models")
//    @EntityGraph(//avoid n+1 problem
//            value = "brandsWithModels",
//            attributePaths = "models"
//    )
//    List<Brand> getAllBrands();
}
