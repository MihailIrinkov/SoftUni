package com.example.football.repository;

import com.example.football.models.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//ToDo:
@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {

//    Optional<Stat> findByPassing(Float passing);
//    Optional<Stat> findByShooting(Float shooting);
//    Optional<Stat> findByEndurance(Float endurance);
    Optional<Stat> findByPassingOrShootingOrEndurance(Float passing, Float endurance, Float shooting);
}
