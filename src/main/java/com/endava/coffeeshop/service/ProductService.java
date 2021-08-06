package com.endava.coffeeshop.service;

import com.endava.coffeeshop.model.Products;
import com.endava.coffeeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {

    @Autowired
    private  ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return (List<Products>) productRepository.findAll();
    }

    public Products addNewProduct(Products products) {
        return productRepository.save(products);
    }

    public Products find(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

//    public void update(Products products, int id) {
//        productRepository.
//    }

}
