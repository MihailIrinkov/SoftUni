package com.softuni.shopping_list.service.impl;

import com.softuni.shopping_list.entity.CategoryName;
import com.softuni.shopping_list.entity.Product;
import com.softuni.shopping_list.entity.dto.HomeViewDTO;
import com.softuni.shopping_list.entity.dto.ProductDTO;
import com.softuni.shopping_list.repository.ProductRepository;
import com.softuni.shopping_list.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {

    private final ProductRepository productRepository;

    public HomeServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public HomeViewDTO getProducts() {

        HomeViewDTO homeViewDTO = new HomeViewDTO();

        List<ProductDTO> foods = getProductsByCategory(CategoryName.FOOD);
        List<ProductDTO> drinks = getProductsByCategory(CategoryName.DRINK);
        List<ProductDTO> household = getProductsByCategory(CategoryName.HOUSEHOLD);
        List<ProductDTO> other = getProductsByCategory(CategoryName.OTHER);

        homeViewDTO.setFoods(foods);
        homeViewDTO.setDrinks(drinks);
        homeViewDTO.setHousehold(household);
        homeViewDTO.setOther(other);


        return homeViewDTO;
    }

    @Override
    public void buySingleProduct(Long id) {
        Product productToDelete = this.productRepository.findById(id).get();

        this.productRepository.delete(productToDelete);
    }

    @Override
    public void buyAllProducts() {
                this.productRepository.deleteAll();
    }


    private List<ProductDTO> getProductsByCategory(CategoryName categoryName) {
        return this.productRepository
                .findByCategory_Name(categoryName)
                .stream().map(product -> new ProductDTO()
                        .setName(product.getName())
                        .setPrice(product.getPrice())
                        .setId(product.getId())).collect(Collectors.toList());
    }



}
