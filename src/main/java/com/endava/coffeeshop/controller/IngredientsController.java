package com.endava.coffeeshop.controller;


import com.endava.coffeeshop.assembler.IngredientModelAssembler;
import com.endava.coffeeshop.model.Ingredients;
import com.endava.coffeeshop.repository.IngredientsRepository;
import com.endava.coffeeshop.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/ingredients")
public class IngredientsController {
    private final IngredientsRepository ingredientsRepository;
    private final IngredientsService ingredientsService;
    private final IngredientModelAssembler ingredientModelAssembler;

    @Autowired
    public IngredientsController(IngredientsRepository ingredientsRepository, IngredientsService ingredientsService, IngredientModelAssembler ingredientModelAssembler) {
        this.ingredientsRepository = ingredientsRepository;
        this.ingredientsService = ingredientsService;
        this.ingredientModelAssembler = ingredientModelAssembler;
    }

    @GetMapping("/allIngredients")
    public ResponseEntity<List<Ingredients>> getIncredients() {
        List<Ingredients> incredients = null;
        incredients = ingredientsService.getAllIncredient();
        return new ResponseEntity<List<Ingredients>>(incredients, HttpStatus.OK);
    }

    @PostMapping("/newIngredient")
    public ResponseEntity<Ingredients> addIncredient(@RequestBody Ingredients incredient) {
        Ingredients ingredients = null;
        try {
            ingredients = ingredientsService.addNewIncredient(incredient);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Ingredients>(ingredients, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        ingredientsService.deleteIncredient(id);
    }

    @PutMapping("update/{id}")
   public ResponseEntity<Ingredients> update(@PathVariable Integer id, @RequestBody Ingredients ingredients) {
        Optional<Ingredients> incredient = ingredientsRepository.findById(id);
        if (incredient.isPresent()) {
            Ingredients _incredient = incredient.get();
            _incredient.setName(ingredients.getName());
            _incredient.setPrice(ingredients.getPrice());
            _incredient.setAmount_stored(ingredients.getAmount_stored());
            return new ResponseEntity<>(ingredientsService.addNewIncredient(_incredient), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("ingredients/{id}")
    public Ingredients getIncredientById(@PathVariable Integer id) {
        return ingredientsService.find(id);
    }

    @GetMapping("ingredient/{id}")
    public EntityModel<Ingredients> one(@PathVariable Integer id) {
        Ingredients ingredients = ingredientsService.find(id);
        return ingredientModelAssembler.toModel(ingredients);
    }

    @GetMapping("all")
    public CollectionModel<EntityModel <Ingredients>> all() {
        return ingredientModelAssembler.toCollectionModel(ingredientsRepository.findAll());
    }
}
