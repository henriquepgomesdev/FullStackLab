package org.example.cdi.service;


import org.example.cdi.domain.Selic;
import org.example.cdi.model.SelicInput;
import org.example.cdi.repository.SelicRepository;
import org.example.movimentacao.domain.Movimentacao;
import org.example.movimentacao.model.MovimentacaoInput;
import org.example.movimentacao.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelicService {

    @Autowired
    private SelicRepository repository;

    public void create(SelicInput input) {
        repository.save(new Selic(input));
    }

    public List<Selic> getAll() {
        return repository.findAll();
    }
}
