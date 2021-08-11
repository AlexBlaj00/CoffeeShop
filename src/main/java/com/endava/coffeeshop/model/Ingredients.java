package com.endava.coffeeshop.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredients {
    @Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "price")
    private float Price;
    @Column(name = "amount_stored")
    private Integer amount_stored;

//    @ManyToMany(mappedBy = "ingredientsSet")
//    List<Recipes> recipesSet;
//
//    public List<Recipes> getRecipesSet() {
//        return recipesSet;
//    }
//
//    public void setRecipesSet(List<Recipes> recipesSet) {
//        this.recipesSet = recipesSet;
//    }

    public Ingredients() {
    }

    public Ingredients(Integer id, String name, float price, Integer amount_stored) {
        this.Id = id;
        this.Name = name;
        this.Price = price;
        this.amount_stored = amount_stored;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public Integer getAmount_stored() {
        return amount_stored;
    }

    public void setAmount_stored(Integer amount_stored) {
        this.amount_stored = amount_stored;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return Float.compare(that.Price, Price) == 0 && Objects.equals(Id, that.Id) && Objects.equals(Name, that.Name) && Objects.equals(amount_stored, that.amount_stored);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Price, amount_stored);
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", amount_stored=" + amount_stored +
                '}';
    }
}
