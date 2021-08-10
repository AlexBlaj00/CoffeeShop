package com.endava.coffeeshop.repository;


import com.endava.coffeeshop.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Integer> {

    //@Query("select r.ingredients, c.Name from Coffee c join Recipes r on c.recipe_id = r.id_recipe")
    //public String findRecipes();
}
