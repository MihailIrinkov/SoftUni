package com.softuni.shopping_list.service.impl;

import com.softuni.shopping_list.entity.Category;
import com.softuni.shopping_list.entity.CategoryName;
import com.softuni.shopping_list.entity.Product;
import com.softuni.shopping_list.entity.dto.ProductAddBindingModel;
import com.softuni.shopping_list.repository.CategoryRepository;
import com.softuni.shopping_list.repository.ProductRepository;
import com.softuni.shopping_list.service.LoggedUser;
import com.softuni.shopping_list.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final LoggedUser loggedUser;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              LoggedUser loggedUser,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.loggedUser = loggedUser;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean addProduct(ProductAddBindingModel productAddBindingModel) {

        Optional<Product> optionalProduct =
                this.productRepository.findByName(productAddBindingModel.getName());

        if (optionalProduct.isEmpty()) {

            Category category = this.categoryRepository.findByName(productAddBindingModel.getCategory()).get();

            Product product = new Product()
                    .setName(productAddBindingModel.getName())
                    .setDescription(productAddBindingModel.getDescription())
                    .setPrice(productAddBindingModel.getPrice())
                    .setNeededBefore(productAddBindingModel.getNeededBefore())
                    .setCategory(category);

            this.productRepository.save(product);

            return true;
        }

        return false;
    }
}
