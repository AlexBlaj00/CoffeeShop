package com.endava.coffeeshop.repository;

import com.endava.coffeeshop.model.Coffee;
import com.endava.coffeeshop.model.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
//    Optional<Products> findById(int id);
//    List<Products> findAll();
//    @Query("select r.ingredients, c.Name from Coffee c join Recipes r on C.recipe_id = R.id_recipe")
//    public String coffeeRecipe();
    @Query("select r.name, i.Name, i.Price from RecipeIngredients rc inner join Recipes r on r.id_recipe = rc.re_id\n" +
           "inner join Ingredients i on i.Id = rc.ing_id" )
    public List<String> coffee();
}
