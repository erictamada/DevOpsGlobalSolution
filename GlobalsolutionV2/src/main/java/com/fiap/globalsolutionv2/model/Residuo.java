package com.fiap.globalsolutionv2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Residuo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long residuoId;
    private String codigoDeBarras;
    private int pontos;
    private String descricao;

    public long getResiduoId() {
        return residuoId;
    }

    public void setResiduoId(long residuoId) {
        this.residuoId = residuoId;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
