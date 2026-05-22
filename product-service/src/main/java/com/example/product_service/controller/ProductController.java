package com.example.product_service.controller;

import com.example.product_service.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(
            @RequestParam(defaultValue = "USD") String moeda
    ) {
        return productService.getProducts(moeda);
    }
}