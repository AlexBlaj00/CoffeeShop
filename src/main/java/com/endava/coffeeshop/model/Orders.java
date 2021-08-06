package com.endava.coffeeshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "orders")
public class Orders {
    @Id
    @Column (name = "order_id")
    private Integer Order_id;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @Column(name = "product_id")
    private String Product_id;
    @Column(name = "amount")
    private Integer Amount;

    public Orders() {
    }

    public Orders(Integer order_id, String product_id, Integer amount) {
        Order_id = order_id;
        Product_id = product_id;
        Amount = amount;
    }

    public Integer getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Integer order_id) {
        Order_id = order_id;
    }

    public String getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(String product_id) {
        Product_id = product_id;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "Order_id='" + Order_id + '\'' +
                ", Product_id='" + Product_id + '\'' +
                ", Amount=" + Amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(Order_id, orders.Order_id) && Objects.equals(Product_id, orders.Product_id) && Objects.equals(Amount, orders.Amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Order_id, Product_id, Amount);
    }
}
