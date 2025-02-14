package org.example.configuracaoativo.controllers;

import jakarta.validation.Valid;
import org.example.configuracaoativo.domain.ConfiguracaoAtivo;
import org.example.configuracaoativo.model.ConfiguracaoAtivoInput;
import org.example.configuracaoativo.service.ConfiguracaoAtivoService;
import org.example.domain.User;
import org.example.dto.AutheticationDTO;
import org.example.dto.LoginResponseDTO;
import org.example.dto.RegisterDTO;
import org.example.infra.security.TokenService;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("configuracao-ativo")
public class ConfiguracaoAtivoController {

    @Autowired
    private ConfiguracaoAtivoService service;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid ConfiguracaoAtivoInput input) {
        System.out.println(input);
        service.create(input);
        System.out.println("Cadastro ok");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<ConfiguracaoAtivo>> list() {
        System.out.println("Requisicao ok");
        return ResponseEntity.ok(service.getAll());
    }

}
