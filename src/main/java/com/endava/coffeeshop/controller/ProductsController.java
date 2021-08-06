package com.endava.coffeeshop.controller;

import com.endava.coffeeshop.model.Products;
import com.endava.coffeeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {


    private final ProductRepository productRepository;
    //private ProductModelAssembler modelAssembler;
    @Autowired
    public ProductsController(ProductRepository productRepository) { //ProductModelAssembler modelAssembler) {
        this.productRepository = productRepository;
        //this.modelAssembler = modelAssembler;
    }

    @GetMapping("/index")
    public String cv() {
        return "smth";
    }

    @GetMapping("/products")
    public List<Products> allProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<Products> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

   /* @GetMapping("products/{id}")
    public EntityModel<Products> one(@PathVariable Integer id) {
        return modelAssembler.toModel(productRepository.findById(id));
    }

    @GetMapping("/products")
    public CollectionModel<EntityModel <Products>> all() {
        return modelAssembler.toCollectionModel(productRepository.findAll());
    }*/
}

