package br.com.luiseduardo.kanban.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "quadros")
public class Quadro {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "quadro")
    private List<Coluna> colunas;

    public Quadro(String nome, List<Coluna> colunas) {
        this.nome = nome;
        this.colunas = colunas;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Coluna> getColunas() {
        return colunas;
    }

    public void setColunas(List<Coluna> colunas) {
        this.colunas = colunas;
    }

    
}
