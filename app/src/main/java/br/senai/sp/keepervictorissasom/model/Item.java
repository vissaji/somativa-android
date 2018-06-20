package br.senai.sp.keepervictorissasom.model;

import java.util.Date;

public class Item {

    private Long id;
    private Patrimonio patrimonio;

    private Ambiente ambiente;

    private Usuario usuario;

    private Date data;

    public Item(Long id, Patrimonio patrimonio, Ambiente ambiente, Usuario usuario, Date data) {
        this.id = id;
        this.patrimonio = patrimonio;
        this.ambiente = ambiente;
        this.usuario = usuario;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patrimonio getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Patrimonio patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
