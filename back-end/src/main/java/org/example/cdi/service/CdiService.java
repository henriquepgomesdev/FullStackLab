package org.example.cdi.service;


import org.example.cdi.domain.Cdi;
import org.example.cdi.model.CdiInput;
import org.example.cdi.repository.CdiRepository;
import org.example.movimentacao.domain.Movimentacao;
import org.example.movimentacao.model.MovimentacaoInput;
import org.example.movimentacao.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CdiService {

    @Autowired
    private CdiRepository repository;

    public void create(CdiInput input) {
        repository.save(new Cdi(input));
    }

    public List<Cdi> getAll() {
        return repository.findAll();
    }
}
