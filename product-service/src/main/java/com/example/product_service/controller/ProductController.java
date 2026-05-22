package com.example.product_service.controller;

import com.example.product_service.model.CotacaoResponse;
import com.example.product_service.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{moeda}")
    public CotacaoResponse getProducts(@PathVariable String moeda) {
        return productService.getProducts(moeda);
    }
}