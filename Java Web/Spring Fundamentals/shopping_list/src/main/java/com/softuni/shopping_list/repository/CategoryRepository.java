package com.softuni.shopping_list.repository;

import com.softuni.shopping_list.entity.Category;
import com.softuni.shopping_list.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryName name);
}
