package com.github.ludmylla.productcatalog.controller;

import com.github.ludmylla.productcatalog.model.Product;
import com.github.ludmylla.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public Iterable<Product> list() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable("id") Integer id){
        return productRepository.findById(id);
    }

    @GetMapping("/name/{name}")
    public Iterable<Product> findByName(@PathVariable("id") String name){
        return productRepository.findByName(name);
    }
}
