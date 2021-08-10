package com.endava.coffeeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "recipeingredients")
public class RecipeIngredients implements Serializable {
    @Id
    @Column(name = "re_id")
    private Integer re_id;
    @Id
    @Column(name = "ing_id")
    private Integer ing_id;

    public RecipeIngredients(Integer re_id, Integer ing_id) {
        this.re_id = re_id;
        this.ing_id = ing_id;
    }

    public RecipeIngredients() {

    }

    public Integer getRe_id() {
        return re_id;
    }

    public void setRe_id(Integer re_id) {
        this.re_id = re_id;
    }

    public Integer getIng_id() {
        return ing_id;
    }

    public void setIng_id(Integer ing_id) {
        this.ing_id = ing_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredients that = (RecipeIngredients) o;
        return Objects.equals(re_id, that.re_id) && Objects.equals(ing_id, that.ing_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(re_id, ing_id);
    }

    @Override
    public String toString() {
        return "RecipeIngredients{" +
                "re_id=" + re_id +
                ", ing_id=" + ing_id +
                '}';
    }
}
