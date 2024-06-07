package com.fiap.globalsolutionv2.service;

import com.fiap.globalsolutionv2.model.Residuo;
import com.fiap.globalsolutionv2.model.dto.ResiduoDTO;
import com.fiap.globalsolutionv2.repository.ResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;
    public ResiduoDTO convertToDTO(Residuo residuo) {
        ResiduoDTO dto = new ResiduoDTO();
        dto.setResiduoId(residuo.getResiduoId());
        dto.setCodigoDeBarras(residuo.getCodigoDeBarras());
        dto.setDescricao(residuo.getDescricao());
        dto.setPontos(residuo.getPontos());
        return dto;
    }

    public Residuo convertToEntity(ResiduoDTO dto) {
        Residuo residuo = new Residuo();
        residuo.setResiduoId(dto.getResiduoId());
        residuo.setCodigoDeBarras(dto.getCodigoDeBarras());
        residuo.setDescricao(dto.getDescricao());
        residuo.setPontos(dto.getPontos());
        return residuo;
    }

    public ResiduoDTO findByCodigoDeBarras(String codigoDeBarras) {
        Optional<Residuo> residuo = residuoRepository.findResiduoByCodigoDeBarras(codigoDeBarras);

        return residuo.map(this::convertToDTO).orElse(null);

    }

}
