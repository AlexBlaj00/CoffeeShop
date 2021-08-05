package com.endava.coffeeshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "price")
    private float Price;
    @Column(name = "amount_stored")
    private Integer Amount_stored;
    @Column(name = "incredients")
    private String Incredients;

    public Products(Integer id, String name, float price, Integer amount_stored, String incredients) {
        Id = id;
        Name = name;
        Price = price;
        Amount_stored = amount_stored;
        Incredients = incredients;
    }

    public Products() {

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
        return Amount_stored;
    }

    public void setAmount_stored(Integer amount_stored) {
        Amount_stored = amount_stored;
    }

    public String getIncredients() {
        return Incredients;
    }

    public void setIncredients(String incredients) {
        Incredients = incredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Float.compare(products.Price, Price) == 0 && Objects.equals(Id, products.Id) && Objects.equals(Name, products.Name) && Objects.equals(Amount_stored, products.Amount_stored) && Objects.equals(Incredients, products.Incredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Price, Amount_stored, Incredients);
    }

    @Override
    public String toString() {
        return "Products{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Amount_stored=" + Amount_stored +
                ", Incredients='" + Incredients + '\'' +
                '}';
    }
}
