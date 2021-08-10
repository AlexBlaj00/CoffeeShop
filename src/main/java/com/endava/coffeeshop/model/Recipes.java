package com.endava.coffeeshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_recipe")
    private Integer id_recipe;

    @Column(name = "name")
    private String name;

//    @ManyToMany
//    @JoinTable(name = "recipeingredients", joinColumns = @JoinColumn(name = "re_id"), inverseJoinColumns = @JoinColumn(name = "ing_id"))
//    Set<Ingredients> ingredientsSet;

    public Recipes(Integer id_recipe, String name ) {
        this.id_recipe = id_recipe;
        this.name = name;
    }

    public Recipes() {
    }

//    public Set<Ingredients> getIngredientsSet() {
//        return ingredientsSet;
//    }
//
//    public void setIngredientsSet(Set<Ingredients> ingredientsSet) {
//        this.ingredientsSet = ingredientsSet;
//    }

    public Integer getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(Integer id_recipe) {
        this.id_recipe = id_recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return Objects.equals(id_recipe, recipes.id_recipe) && Objects.equals(name, recipes.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_recipe, name);
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "id_recipe=" + id_recipe +
                ", name='" + name + '\'' +
                '}';
    }
}
