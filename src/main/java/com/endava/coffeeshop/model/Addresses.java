package com.endava.coffeeshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_add")
    private Integer id_add;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "addresses")
    private Customer customer;

    public Addresses(Integer id_add, String address, Customer customer) {
        this.id_add = id_add;
        this.address = address;
        this.customer = customer;
    }

    public Addresses() {

    }

    public Integer getId_add() {
        return id_add;
    }

    public void setId_add(Integer id_add) {
        this.id_add = id_add;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addresses addresses = (Addresses) o;
        return Objects.equals(id_add, addresses.id_add) && Objects.equals(address, addresses.address) && Objects.equals(customer, addresses.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_add, address, customer);
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "id_add=" + id_add +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                '}';
    }
}
