package com.endava.coffeeshop.service;

import com.endava.coffeeshop.model.Coffee;
import com.endava.coffeeshop.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getAllProducts() {
        return (List<Coffee>) coffeeRepository.findAll();
    }

    public Coffee addNewProduct(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public Coffee find(Integer id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Integer id) {
        coffeeRepository.deleteById(id);
    }

//    public String getRecipes() {
//        return coffeeRepository.coffeeRecipe();
//    }

}
