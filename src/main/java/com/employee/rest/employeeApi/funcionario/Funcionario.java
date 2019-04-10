package com.employee.rest.employeeApi.funcionario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Funcionario implements Serializable {
    private static final long serialVersionUID = -9109414221418128481L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="PROJETO_FUNCIONARIO",
            joinColumns={@JoinColumn(name="PROJETO_ID")},
            inverseJoinColumns={@JoinColumn(name="FUNCIONARIO_ID")})
    private List<Projeto> projetos;

    public Funcionario() {
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}