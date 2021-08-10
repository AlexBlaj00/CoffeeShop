package com.endava.coffeeshop.controller;

import com.endava.coffeeshop.model.Coffee;
import com.endava.coffeeshop.model.Ingredients;
import com.endava.coffeeshop.model.Recipes;
import com.endava.coffeeshop.repository.RecipesRepository;
import com.endava.coffeeshop.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipesRepository recipesRepository;

    @Autowired
    public RecipeController(RecipeService recipeService, RecipesRepository recipesRepository) {
        this.recipeService = recipeService;
        this.recipesRepository = recipesRepository;
    }

//    @GetMapping("/allRecipes")
//    public ResponseEntity<String> allRecipes() {
//        String recipes = null;
//        recipes = recipesRepository.findRecipes();
//        return new ResponseEntity<String>( recipes, HttpStatus.OK);
//    }

//    @GetMapping("allRecipes")
//    public ResponseEntity<?> getAllRecipes() {
//        Map<String, List<Ingredients>> retete = new HashMap<String, List<Ingredients>>();
//        retete = recipeService.getAllRecipes(retete);
//        return (ResponseEntity<?>) retete;
//    }
    @GetMapping("allRecipes")
    public ResponseEntity<List<Recipes>> getProducts() {
        List<Recipes> recipes = null;
        recipes = recipeService.gettAll();
        return new ResponseEntity<List<Recipes>>(recipes, HttpStatus.OK);
    }

    @PostMapping("addNewRecipes")
    public ResponseEntity<Recipes> addRecipe(@RequestBody Recipes recipe) {
        Recipes recipes = null;
        try {
            recipes = recipeService.addNewRecipe(recipe);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Recipes>(recipes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/recipe/{id}")
    public Recipes getRecipeById(@PathVariable Integer id) {
        return recipeService.find(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Recipes> update (@PathVariable Integer id, @RequestBody Recipes recipes) {
        Optional<Recipes> recipe = recipesRepository.findById(id);
        if (recipe.isPresent()) {
            Recipes _recipe = recipe.get();
            _recipe.setName(recipes.getName());
            return new ResponseEntity<>(recipeService.addNewRecipe(_recipe), HttpStatus.OK);
        }
        else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
