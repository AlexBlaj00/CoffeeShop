package com.endava.coffeeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Incredients {
    @Id
    @Column(name = "id")
    private Integer Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "price")
    private float Price;
    @Column(name = "amount_stored")
    private Integer amount_stored;
    public Incredients() {
    }

    public Incredients(Integer id, String name, float price, Integer amount_stored) {
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
        Incredients that = (Incredients) o;
        return Float.compare(that.Price, Price) == 0 && Objects.equals(Id, that.Id) && Objects.equals(Name, that.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Price, amount_stored);
    }

    @Override
    public String toString() {
        return "Incredients{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", amount_stored=" + amount_stored +
                '}';
    }
}
