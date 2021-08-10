package com.endava.coffeeshop.service;

import com.endava.coffeeshop.model.Ingredients;
import com.endava.coffeeshop.model.Recipes;
import com.endava.coffeeshop.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    private final RecipesRepository recipesRepository;

    @Autowired
    public RecipeService(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

//    public Recipes getRecipe(String name) {
//        return recipesRepository.fin
//    public Map<String, List<Ingredients>> getAllRecipes(Map<String, List<Ingredients>> retete) {
//        List<Recipes> recipes = null;
//        Map<String, List<Ingredients>> _retete = new HashMap<String, List<Ingredients>>();
//        recipes =  recipesRepository.findAll();
//        for (Recipes i : recipes) {
//            _retete.put(i.getName(), i.getIngredients());
//            List<Ingredients> cv = i.getIngredients();
//            System.out.println(cv);
//        }
//        //_retete.put(recipes.getName(), recipes.getIngredients());
//        return retete;
//    }

    public List<Recipes> gettAll() {
        return recipesRepository.findAll();
    }
    public Recipes addNewRecipe(Recipes recipes) {
        return recipesRepository.save(recipes);
    }
    public Recipes find(Integer id) {
        return recipesRepository.findById(id).orElse(null);
    }
    public void deleteRecipe(Integer id_recipe) {
        recipesRepository.deleteById(id_recipe);
    }
}
