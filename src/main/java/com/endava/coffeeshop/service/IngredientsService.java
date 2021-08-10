package com.endava.coffeeshop.service;

import com.endava.coffeeshop.model.Ingredients;
import com.endava.coffeeshop.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {

    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientsService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<Ingredients> getAllIncredient() {
        return ingredientsRepository.findAll();
    }
    public Ingredients addNewIncredient(Ingredients incredient) {
        return ingredientsRepository.save(incredient);
    }

    public Ingredients find(Integer id) {
        return ingredientsRepository.findById(id).orElse(null);
    }

    public void deleteIncredient(Integer id) {
        ingredientsRepository.deleteById(id);
    }
}
