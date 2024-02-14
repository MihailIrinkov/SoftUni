package com.resellerapp.repository;

import com.resellerapp.model.emums.ConditionName;
import com.resellerapp.model.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, UUID> {

    Condition findByName(ConditionName condition);
}
