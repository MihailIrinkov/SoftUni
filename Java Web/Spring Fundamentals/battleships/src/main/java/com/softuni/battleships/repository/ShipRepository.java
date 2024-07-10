package com.softuni.battleships.repository;

import com.softuni.battleships.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {


    Optional<Ship> findByName(String name);
    List<Ship> findAllByUserId(Long id);
    List<Ship> findAllByUserIdNot(Long id);
    List<Ship> findByOrderByNameAscHealthAscPowerAsc();

}
