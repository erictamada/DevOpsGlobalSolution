package com.fiap.globalsolutionv2.security;

import com.fiap.globalsolutionv2.model.Usuario;
import com.fiap.globalsolutionv2.model.dto.UsuarioDTO;
import com.fiap.globalsolutionv2.repository.UsuarioRepository;
import com.fiap.globalsolutionv2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioDTO user = usuarioService.getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getSenha(),
                true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
