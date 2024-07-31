package com.softuni.gira.repository;

import com.softuni.gira.model.ClassificaionName;
import com.softuni.gira.model.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    Optional<Classification> findByClassificaionName(ClassificaionName ClassificaionName);
}
