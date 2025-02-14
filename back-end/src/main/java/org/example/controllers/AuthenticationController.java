package org.example.controllers;

import jakarta.validation.Valid;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutheticationDTO autheticationDTO) {
        System.out.println("Requisição ok");
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(autheticationDTO.login(), autheticationDTO.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        System.out.println("Sucesso");
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        System.out.println("Requisição ok");
        if (this.repository.findByLogin(registerDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User user = new User(registerDTO.login(), encryptedPassword, registerDTO.role());

        this.repository.save(user);
        System.out.println("Sucesso");
        return ResponseEntity.ok().build();
    }

}
