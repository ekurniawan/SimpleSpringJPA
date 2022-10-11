package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.model.Product;
import com.rapidtech.springdatajpapgsql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAllProducts();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveOrUpdateProduct(product);
    }
}
