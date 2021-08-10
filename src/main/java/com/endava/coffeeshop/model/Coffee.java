package com.endava.coffeeshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "price")
    private float Price;
    @Column(name = "recipe_id")
    @JoinColumn(name = "recipe_id")
    private Integer recipe_id;


    public Coffee(Integer id, String name, float price, Integer recipe_id) {
        Id = id;
        Name = name;
        Price = price;
        this.recipe_id = recipe_id;
    }

    public Coffee() {

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

    public Integer getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Integer recipe_id) {
        this.recipe_id = recipe_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Float.compare(coffee.Price, Price) == 0 && Objects.equals(Id, coffee.Id) && Objects.equals(Name, coffee.Name) && Objects.equals(recipe_id, coffee.recipe_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Price, recipe_id);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", recipe_id=" + recipe_id +
                '}';
    }
}
