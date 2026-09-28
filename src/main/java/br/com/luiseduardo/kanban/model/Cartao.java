package br.com.luiseduardo.kanban.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartoes")
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "coluna_id")
    private Coluna coluna;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioAtribuido;

    public Cartao(String titulo, String descricao, Coluna coluna, Usuario usuarioAtribuido) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.coluna = coluna;
        this.usuarioAtribuido = usuarioAtribuido;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Coluna getColuna() {
        return coluna;
    }

    public void setColuna(Coluna coluna) {
        this.coluna = coluna;
    }

    public Usuario getUsuarioAtribuido() {
        return usuarioAtribuido;
    }

    public void setUsuarioAtribuido(Usuario usuarioAtribuido) {
        this.usuarioAtribuido = usuarioAtribuido;
    }

}
