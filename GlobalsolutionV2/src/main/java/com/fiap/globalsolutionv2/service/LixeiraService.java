package com.fiap.globalsolutionv2.service;

import com.fiap.globalsolutionv2.model.Lixeira;
import com.fiap.globalsolutionv2.model.dto.LixeiraDTO;
import com.fiap.globalsolutionv2.repository.LixeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LixeiraService {

    @Autowired
    private LixeiraRepository lixeiraRepository;

    public LixeiraDTO convertToDTO(Lixeira lixeira) {
        LixeiraDTO dto = new LixeiraDTO();
        dto.setLixeiraId(lixeira.getLixeiraId());
        dto.setLocalizacao(lixeira.getLocalizacao());
        dto.setQrCode(lixeira.getQrCode());
        return dto;
    }

    public Lixeira convertToEntity(LixeiraDTO dto) {
        Lixeira lixeira = new Lixeira();
        lixeira.setLixeiraId(dto.getLixeiraId());
        lixeira.setLocalizacao(dto.getLocalizacao());
        lixeira.setQrCode(dto.getQrCode());
        return lixeira;
    }

}
