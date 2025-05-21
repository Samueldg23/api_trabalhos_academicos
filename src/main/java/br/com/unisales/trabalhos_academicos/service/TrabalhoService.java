package br.com.unisales.trabalhos_academicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.trabalhos_academicos.model.TrabalhoAcademico;
import br.com.unisales.trabalhos_academicos.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repository;

    public List<TrabalhoAcademico> findAll() {
        return repository.findAll();
    }

    public Optional<TrabalhoAcademico> findById(Long id) {
        return repository.findById(id);
    }

    public List<TrabalhoAcademico> listarPorAluno(Long alunoId) {
        return repository.findByAlunoId(alunoId);
    }
}
