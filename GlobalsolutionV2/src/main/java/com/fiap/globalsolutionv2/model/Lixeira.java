package com.fiap.globalsolutionv2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lixeira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lixeiraId;
    private String localizacao;
    private String qrCode;

    public long getLixeiraId() {
        return lixeiraId;
    }

    public void setLixeiraId(long lixeiraId) {
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
