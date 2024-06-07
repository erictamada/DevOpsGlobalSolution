package com.fiap.globalsolutionv2.service;

import com.fiap.globalsolutionv2.model.Recompensa;
import com.fiap.globalsolutionv2.model.dto.RecompensaDTO;
import com.fiap.globalsolutionv2.repository.RecompensaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecompensaService {

    @Autowired
    private RecompensaRepository recompensaRepository;

    public RecompensaDTO convertToDTO(Recompensa recompensa) {
        RecompensaDTO dto = new RecompensaDTO();
        dto.setRecompensaId(recompensa.getRecompensaId());
        dto.setDescricao(recompensa.getDescricao());
        dto.setPontosNecessarios(recompensa.getPontosNecessarios());
        return dto;
    }

    public Recompensa convertToEntity(RecompensaDTO dto) {
        Recompensa recompensa = new Recompensa();
        recompensa.setRecompensaId(dto.getRecompensaId());
        recompensa.setDescricao(dto.getDescricao());
        recompensa.setPontosNecessarios(dto.getPontosNecessarios());
        return recompensa;
    }

    public List<RecompensaDTO> getAll(){
        List<Recompensa> recompensas = recompensaRepository.findAll();
        List<RecompensaDTO> recompensasDTO = recompensas.stream().map(this::convertToDTO).collect(Collectors.toList());
        return recompensasDTO;
    }
}
