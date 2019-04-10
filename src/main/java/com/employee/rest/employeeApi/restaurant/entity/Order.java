package com.employee.rest.employeeApi.restaurant.entity;



import com.employee.rest.employeeApi.funcionario.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.awt.image.PixelConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private long orderID;

    private String orderNo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Customer customer;


    @ManyToMany(mappedBy="pedidos", cascade = CascadeType.ALL)
    //@JsonIgnore
    private List<Item> items;


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }




    private String paymentMethod;

    private BigDecimal total;

    public Order( String orderNo,  String paymentMethod, BigDecimal total) {

        this.orderNo = orderNo;
        this.paymentMethod = paymentMethod;
        this.total = total;
    }

    public Order() {
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


}
