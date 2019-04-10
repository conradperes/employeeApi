package com.employee.rest.employeeApi.university;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Aluno")
public class Aluno extends Usuario{

    @ManyToOne
    private Faculdade faculdade;

    @ManyToOne
    private FaixaPreco faixaPreco;

    @ManyToMany
    private List<LocalUtilProximo> locaisUteisProximos;

    /*fetch=FetchType.EAGER,*/
    @ManyToMany(cascade = {CascadeType.DETACH})
    private List<BeneficioIncluso> beneficiosInclusos;

    public List<BeneficioIncluso> getBeneficiosInclusos() {
        return beneficiosInclusos;
    }

    public void setBeneficiosInclusos(List<BeneficioIncluso> beneficiosInclusos) {
        this.beneficiosInclusos = beneficiosInclusos;
    }


}