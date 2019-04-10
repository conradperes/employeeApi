package com.employee.rest.employeeApi.restaurant.entity;

import com.employee.rest.employeeApi.funcionario.Funcionario;
import com.employee.rest.employeeApi.funcionario.Projeto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto")
public class Item implements Serializable {


    @Id
    @GeneratedValue
    private long itemID;

    private String name;

    private BigDecimal price;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="PEDIDOS_POR_ITEM",
            joinColumns={@JoinColumn(name="orderID")},
            inverseJoinColumns={@JoinColumn(name="itemID")})
    @JsonIgnore
    private List<Order> pedidos;


    public Item(String name, BigDecimal price) {

        this.name = name;
        this.price = price;
    }

    public List<Order> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Order> pedidos) {
        this.pedidos = pedidos;
    }

    public Item() {
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
