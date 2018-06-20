package br.senai.sp.keepervictorissasom.model;

import java.util.Date;

public class Patrimonio {

    private Long id;

    private Categoria categoria;

    private String nome;
    private Usuario usuario;
    private Date dataCadastro;

    public Patrimonio(Long id, Categoria categoria, String nome, Usuario usuario, Date dataCadastro) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.usuario = usuario;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
