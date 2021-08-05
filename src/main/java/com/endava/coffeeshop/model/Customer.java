package com.endava.coffeeshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    private String Name;

    //@OneToOne( cascade  = GenerationType.AUTO)
    @JoinColumn(name = "id_order", referencedColumnName = "order_id")
    private int Id_order;

    private boolean Cash;
    private boolean Delivery;
    private Date Date;
    private float Total;

    public Customer() {
    }

    public Customer(String name, Integer id_order, boolean cash, boolean delivery, java.util.Date date, float total) {
        Name = name;
        Id_order = id_order;
        Cash = cash;
        Delivery = delivery;
        Date = date;
        Total = total;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getId_order() {
        return Id_order;
    }

    public void setId_order(Integer id_order) {
        Id_order = id_order;
    }

    public boolean isCash() {
        return Cash;
    }

    public void setCash(boolean cash) {
        Cash = cash;
    }

    public boolean isDelivery() {
        return Delivery;
    }

    public void setDelivery(boolean delivery) {
        Delivery = delivery;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + Name + '\'' +
                ", Id_order='" + Id_order + '\'' +
                ", Cash=" + Cash +
                ", Delivery=" + Delivery +
                ", Date=" + Date +
                ", Total=" + Total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Cash == customer.Cash && Delivery == customer.Delivery && Float.compare(customer.Total, Total) == 0 && Objects.equals(Name, customer.Name) && Objects.equals(Id_order, customer.Id_order) && Objects.equals(Date, customer.Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Id_order, Cash, Delivery, Date, Total);
    }
}
