package br.senai.sp.keepervictorissasom.model;

import java.util.Date;

public class Movimentacao {

    private Long id;
    private Item item;
    private Ambiente origem;
    private Ambiente destino;
    private Date dataMovimentacao;
    private Usuario transportador;

    public Movimentacao(Long id, Item item, Ambiente origem, Ambiente destino, Date dataMovimentacao, Usuario transportador) {
        this.id = id;
        this.item = item;
        this.origem = origem;
        this.destino = destino;
        this.dataMovimentacao = dataMovimentacao;
        this.transportador = transportador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Ambiente getOrigem() {
        return origem;
    }

    public void setOrigem(Ambiente origem) {
        this.origem = origem;
    }

    public Ambiente getDestino() {
        return destino;
    }

    public void setDestino(Ambiente destino) {
        this.destino = destino;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Usuario getTransportador() {
        return transportador;
    }

    public void setTransportador(Usuario transportador) {
        this.transportador = transportador;
    }
}
