package org.example.movimentacao.service;


import org.example.movimentacao.domain.Movimentacao;
import org.example.movimentacao.model.MovimentacaoInput;
import org.example.movimentacao.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    public void create(MovimentacaoInput input) {
        repository.save(new Movimentacao(input, null));
    }

    public List<Movimentacao> getAll() {
        return repository.findAll();
    }
}
