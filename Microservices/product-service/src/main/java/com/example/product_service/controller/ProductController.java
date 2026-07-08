package com.example.product_service.controller;

import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product saveProduct(
            @RequestBody Product product) {

        return service.save(product);

    }

    @GetMapping
    public List<Product> getProducts() {

        return service.getAllProducts();

    }
}