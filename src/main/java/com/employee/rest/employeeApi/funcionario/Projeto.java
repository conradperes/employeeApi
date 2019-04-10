package com.employee.rest.employeeApi.funcionario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1081869386060246794L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    public Projeto() {
    }

    public Projeto(String nome) {
        this.nome = nome;
    }

    @ManyToMany(mappedBy="projetos", cascade = CascadeType.ALL)
    private List<Funcionario> desenvolvedores;

    public List<Funcionario> getDesenvolvedores() { return desenvolvedores; }
    public void setDesenvolvedores(List<Funcionario> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}