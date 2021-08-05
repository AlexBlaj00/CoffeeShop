package com.endava.coffeeshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Incredients {
    @Id
    private String Id;
    private String Name;
    private float Price;

    public Incredients() {
    }

    public Incredients(String id, String name, float price) {
        Id = id;
        Name = name;
        Price = price;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incredients that = (Incredients) o;
        return Float.compare(that.Price, Price) == 0 && Objects.equals(Id, that.Id) && Objects.equals(Name, that.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Price);
    }

    @Override
    public String toString() {
        return "Incredients{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}
