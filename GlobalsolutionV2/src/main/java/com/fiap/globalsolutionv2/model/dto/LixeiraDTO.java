package com.fiap.globalsolutionv2.model.dto;

import jakarta.validation.constraints.NotNull;

public class LixeiraDTO {

    @NotNull
    private Long lixeiraId;
    @NotNull
    private String localizacao;
    @NotNull
    private String qrCode;

    public Long getLixeiraId() {
        return lixeiraId;
    }

    public void setLixeiraId(Long lixeiraId) {
        this.lixeiraId = lixeiraId;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
