package com.employee.rest.employeeApi.university;

import javax.persistence.*;

@Entity
@Table(name="Beneficio_Incluso")
public class BeneficioIncluso {

    @Id
    @GeneratedValue
    private int codigo;

    @Column(name="descricao", length=20, nullable=true)
    private String descricao;

    @Override
    public String toString() {
        return this.descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
