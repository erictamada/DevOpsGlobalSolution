package com.fiap.globalsolutionv2.controller;

import com.fiap.globalsolutionv2.exception.ResourceNotFoundException;
import com.fiap.globalsolutionv2.model.dto.RecompensaDTO;
import com.fiap.globalsolutionv2.model.dto.ResiduoDTO;
import com.fiap.globalsolutionv2.model.dto.UsuarioDTO;
import com.fiap.globalsolutionv2.service.LixeiraService;
import com.fiap.globalsolutionv2.service.RecompensaService;
import com.fiap.globalsolutionv2.service.ResiduoService;
import com.fiap.globalsolutionv2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cleanWave")
public class CleanWaveController {

    @Autowired
    private LixeiraService lixeiraService;

    @Autowired
    private RecompensaService recompensaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ResiduoService residuoService;

    @GetMapping("/home")
    public String homePage(Model model) {
        UsuarioDTO usuario = usuarioService.getByEmail(usuarioService.getUserInfo());
        if (usuario == null) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        model.addAttribute("usuario", usuario);
        return "home";
    }

    @GetMapping("/recompensa")
    public String recompensa(Model model) {
        List<RecompensaDTO> recompensas = recompensaService.getAll();
        UsuarioDTO usuario = usuarioService.getByEmail(usuarioService.getUserInfo());

        if (usuario == null) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        model.addAttribute("recompensas", recompensas);
        model.addAttribute("usuario", usuario);
        return "recompensa";
    }

    @RequestMapping("/recompensa/resgatar")
    public String resgatarRecompensa(@RequestParam Long id, @RequestParam int pontos) {
        usuarioService.resgatarRecompensa(pontos, id);
        return "redirect:/cleanWave/home";
    }

    @GetMapping("/pontos")
    public String pontos(Model model) {
        UsuarioDTO usuario = usuarioService.getByEmail(usuarioService.getUserInfo());
        if (usuario == null) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        model.addAttribute("usuario", usuario);
        return "pontos";
    }

    @RequestMapping("/pontos/resgatar")
    public String resgatarPontos(@RequestParam("usuarioId") Long idUsuario, @RequestParam("codigoDeBarras") String codigoDeBarras, Model model) {
        ResiduoDTO residuoDTO = residuoService.findByCodigoDeBarras(codigoDeBarras);
        if (residuoDTO == null) {
            throw new ResourceNotFoundException("Resíduo não encontrado.");
        }

        usuarioService.resgatarPontos(residuoDTO.getPontos(), idUsuario);
        return "redirect:/cleanWave/home";
    }
}
