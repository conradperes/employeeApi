package com.employee.rest.employeeApi.university;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class FaixaPreco {
    @Id
    @GeneratedValue
    private long id;

    private String nome;

    private BigDecimal valor;
}
