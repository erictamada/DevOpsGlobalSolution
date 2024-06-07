package com.fiap.globalsolutionv2.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ResiduoDTO {

    @NotNull
    private long residuoId;
    @NotNull
    private String codigoDeBarras;
    @NotNull
    @Min(1)
    private int pontos;
    @NotNull
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
