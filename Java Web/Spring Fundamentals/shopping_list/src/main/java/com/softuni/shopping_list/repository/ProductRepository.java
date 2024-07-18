package com.softuni.shopping_list.repository;

import com.softuni.shopping_list.entity.Category;
import com.softuni.shopping_list.entity.CategoryName;
import com.softuni.shopping_list.entity.Product;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findByCategory_Name(CategoryName categoryName);

}
