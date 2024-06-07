package com.fiap.globalsolutionv2.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RecompensaDTO {
    @NotNull
    private long recompensaId;
    @NotNull
    private String descricao;
    @NotNull
    @Min(1)
    private int pontosNecessarios;

    public long getRecompensaId() {
        return recompensaId;
    }

    public void setRecompensaId(long recompensaId) {
        this.recompensaId = recompensaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontosNecessarios() {
        return pontosNecessarios;
    }

    public void setPontosNecessarios(int pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }
}
