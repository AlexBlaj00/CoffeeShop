package com.endava.coffeeshop.controller;

import com.endava.coffeeshop.assembler.RecipeModelAssembler;
import com.endava.coffeeshop.model.Recipes;
import com.endava.coffeeshop.repository.RecipesRepository;
import com.endava.coffeeshop.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipesRepository recipesRepository;
    private final RecipeModelAssembler modelAssembler;

    @Autowired
    public RecipeController(RecipeService recipeService, RecipesRepository recipesRepository, RecipeModelAssembler modelAssembler) {
        this.recipeService = recipeService;
        this.recipesRepository = recipesRepository;
        this.modelAssembler = modelAssembler;
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
    @GetMapping("/allRecipes")
    public ResponseEntity<List<Recipes>> getProducts() {
        List<Recipes> recipes = null;
        recipes = recipeService.gettAll();
        return new ResponseEntity<List<Recipes>>(recipes, HttpStatus.OK);
    }

    @PostMapping("/addNewRecipes")
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

    @PutMapping("/update/{id}")
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

    @GetMapping("/retele/{id}")
    public EntityModel<Recipes> one(@PathVariable Integer id_recipe) {
        Optional<Recipes> byId = recipesRepository.findById(id_recipe);
        return modelAssembler.toModel(byId.orElse(null));
    }

    @GetMapping("/Recipes")
    public CollectionModel<EntityModel <Recipes>> all() {
        return modelAssembler.toCollectionModel(recipesRepository.findAll());
    }
}
