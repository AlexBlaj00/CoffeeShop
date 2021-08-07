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
    @Column(name = "amount_stored")
    private Integer Amount_stored;


    public Coffee(Integer id, String name, float price, Integer amount_stored) {
        Id = id;
        Name = name;
        Price = price;
        Amount_stored = amount_stored;
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

    public Integer getAmount_stored() {
        return Amount_stored;
    }

    public void setAmount_stored(Integer amount_stored) {
        Amount_stored = amount_stored;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Float.compare(coffee.Price, Price) == 0 && Objects.equals(Id, coffee.Id) && Objects.equals(Name, coffee.Name) && Objects.equals(Amount_stored, coffee.Amount_stored);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Price, Amount_stored);
    }

    @Override
    public String toString() {
        return "Products{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Amount_stored=" + Amount_stored +
                '\'' +
                '}';
    }
}
