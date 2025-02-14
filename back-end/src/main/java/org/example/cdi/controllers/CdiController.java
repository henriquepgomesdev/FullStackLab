package org.example.cdi.controllers;

import jakarta.validation.Valid;
import org.example.cdi.domain.Cdi;
import org.example.cdi.domain.Selic;
import org.example.cdi.model.CdiInput;
import org.example.cdi.model.SelicInput;
import org.example.cdi.service.CdiService;
import org.example.movimentacao.domain.Movimentacao;
import org.example.movimentacao.model.MovimentacaoInput;
import org.example.movimentacao.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cdi")
public class CdiController {

    @Autowired
    private CdiService service;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CdiInput input) {
        System.out.println(input);
        service.create(input);
        System.out.println("Cadastro ok");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Cdi>> list() {
        System.out.println("Requisicao ok");
        return ResponseEntity.ok(service.getAll());
    }

}
