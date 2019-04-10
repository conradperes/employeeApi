package com.employee.rest.employeeApi.university;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LocalUtilProximo {
    @Id
    @GeneratedValue
    private long id;

    private String nome;
}
