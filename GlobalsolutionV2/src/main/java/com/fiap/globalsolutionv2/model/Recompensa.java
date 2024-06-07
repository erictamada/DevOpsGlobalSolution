package com.fiap.globalsolutionv2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recompensaId;
    private String descricao;
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
