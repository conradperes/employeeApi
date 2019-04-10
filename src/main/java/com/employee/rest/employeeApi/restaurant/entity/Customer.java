package com.employee.rest.employeeApi.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private long customerID;

    private String name;

    @OneToMany(mappedBy="customer")
    @JsonIgnore
    private List<Order> orders;

    public Customer(String name){//, List<Order> orders) {

        this.name = name;
        //this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                '}';
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
