package com.endava.coffeeshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "orders")
public class Orders {
    @Id
    @Column (name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Order_id;

    @Column(name = "coffee_id")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "coffee_id", referencedColumnName = "id")
    private Integer coffee_id;

    @Column(name = "customer_id")
//    @OneToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    private Integer customer_id;

    @Column(name = "cash")
    private Boolean cash;

    @Column(name = "delivery")
    private Boolean delivery;

    @Column(name = "amount")
    private Integer Amount;

    @Column(name = "total")
    private Integer total;

    public Orders() {
    }

    public Orders(Integer order_id, Coffee coffee, Integer customer, Boolean cash, Boolean delivery, Integer amount, Integer total) {
        Order_id = order_id;
        this.coffee_id = coffee_id;
        this.customer_id = customer_id;
        this.cash = cash;
        this.delivery = delivery;
        Amount = amount;
        this.total = total;
    }

    public Integer getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Integer order_id) {
        Order_id = order_id;
    }

    public Integer getCoffee() {
        return coffee_id;
    }

    public void setCoffee(Integer coffee) {
        this.coffee_id = coffee;
    }

    public Integer getCustomer() {
        return customer_id;
    }

    public void setCustomer(Integer customer) {
        this.customer_id = customer;
    }

    public Boolean getCash() {
        return cash;
    }

    public void setCash(Boolean cash) {
        this.cash = cash;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(Order_id, orders.Order_id) && Objects.equals(coffee_id, orders.coffee_id) && Objects.equals(customer_id, orders.customer_id) && Objects.equals(cash, orders.cash) && Objects.equals(delivery, orders.delivery) && Objects.equals(Amount, orders.Amount) && Objects.equals(total, orders.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Order_id, coffee_id, customer_id, cash, delivery, Amount, total);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "Order_id=" + Order_id +
                ", coffee_id=" + coffee_id +
                ", customer_id=" + customer_id +
                ", cash=" + cash +
                ", delivery=" + delivery +
                ", Amount=" + Amount +
                ", total=" + total +
                '}';
    }
}
