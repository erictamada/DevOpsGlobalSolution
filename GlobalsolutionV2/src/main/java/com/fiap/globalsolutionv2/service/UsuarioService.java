package com.fiap.globalsolutionv2.service;

import com.fiap.globalsolutionv2.model.Usuario;
import com.fiap.globalsolutionv2.model.dto.UsuarioDTO;
import com.fiap.globalsolutionv2.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsuarioId(usuario.getUsuarioId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());
        dto.setPontosAcumulados(usuario.getPontosAcumulados());
        return dto;
    }

    public Usuario convertToEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(dto.getUsuarioId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setPontosAcumulados(dto.getPontosAcumulados());
        return usuario;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public UsuarioDTO getByEmail(String email){
        return convertToDTO(usuarioRepository.findByEmail(email));
    }

    public UsuarioDTO authenticate(String email, String password) {
        UsuarioDTO usuario = getByEmail(email);
        if (usuario != null && password.equals(usuario.getSenha())) {
            return usuario;
        }
        throw new IllegalArgumentException("Invalid email or password");
    }

    public String getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public Usuario findById(Long id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            return usuario;
        }else {
            throw new RuntimeException("Pontos insuficientes para resgatar a recompensa.");
        }
    }
    @Transactional
    public void resgatarRecompensa(int pontos,Long id){
        UsuarioDTO usuarioDTO = convertToDTO(findById(id));
        usuarioDTO.setPontosAcumulados(usuarioDTO.getPontosAcumulados()-pontos);

        usuarioRepository.save(convertToEntity(usuarioDTO));
    }

    @Transactional
    public void resgatarPontos(int pontos,Long id){

        UsuarioDTO usuarioDTO = convertToDTO(findById(id));
        usuarioDTO.setPontosAcumulados(usuarioDTO.getPontosAcumulados()+pontos);

        usuarioRepository.save(convertToEntity(usuarioDTO));
    }

}
