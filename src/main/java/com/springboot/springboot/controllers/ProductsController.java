package com.springboot.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.springboot.springboot.models.Product;
import com.springboot.springboot.services.ProductService;

@RestController
public class ProductsController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }
}
