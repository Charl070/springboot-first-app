package com.springboot.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.springboot.springboot.models.Product;
import com.springboot.springboot.services.ProductService;

@RestController
public class ProductsController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();

        if(products == null) {
            return new ResponseEntity<> (products, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<> (products, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String productId) {

        Product product =productService.getProductById(productId);
        if(product == null) {
            return new ResponseEntity<> (product, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<> (product, HttpStatus.OK);
    }
    
    @PostMapping("product/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    } 
}
