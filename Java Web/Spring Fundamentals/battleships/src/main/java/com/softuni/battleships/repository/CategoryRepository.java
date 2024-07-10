package com.softuni.battleships.repository;

import com.softuni.battleships.model.entity.Category;
import com.softuni.battleships.model.entity.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(CategoryType name);
}
