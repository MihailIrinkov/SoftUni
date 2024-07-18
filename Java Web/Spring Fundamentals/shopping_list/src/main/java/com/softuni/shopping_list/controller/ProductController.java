package com.softuni.shopping_list.controller;

import com.softuni.shopping_list.entity.dto.ProductAddBindingModel;
import com.softuni.shopping_list.service.LoggedUser;
import com.softuni.shopping_list.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private final LoggedUser loggedUser;
    private final ProductService productService;

    public ProductController(LoggedUser loggedUser,
                             ProductService productService) {
        this.loggedUser = loggedUser;
        this.productService = productService;
    }

    @GetMapping("/product-add")
    public ModelAndView addProduct(
            @ModelAttribute("productAddBindingModel")
            ProductAddBindingModel productAddBindingModel
    ) {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("product-add");

    }

    @PostMapping("/product-add")
    public ModelAndView addProduct(
            @ModelAttribute("productAddBindingModel") @Valid
            ProductAddBindingModel productAddBindingModel,
            BindingResult bindingResult
    ) {
        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("product-add");
//            modelAndView.addObject("addProductHasError", true);
            return modelAndView;
        }

        boolean hasSuccessfulAddProduct = this.productService.addProduct(productAddBindingModel);

        if (!hasSuccessfulAddProduct) {
            ModelAndView modelAndView = new ModelAndView("product-add");
            modelAndView.addObject("addProductHasError", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }
}
