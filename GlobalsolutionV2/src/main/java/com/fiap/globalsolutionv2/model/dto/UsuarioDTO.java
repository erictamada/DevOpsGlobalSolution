package com.fiap.globalsolutionv2.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {

    @NotNull
    private long usuarioId;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String senha;
    @NotNull
    @Min(0)
    private int pontosAcumulados;

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPontosAcumulados() {
        return pontosAcumulados;
    }

    public void setPontosAcumulados(int pontosAcumulados) {
        this.pontosAcumulados = pontosAcumulados;
    }
}
