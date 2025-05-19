package br.com.unisales.trabalhos_academicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public TrabalhoAcademico salvar (TrabalhoAcademico trabalho) {
        return repository.save(trabalho);
    }

    public TrabalhoAcademico atualizar (Long id, TrabalhoAcademico novoTrabalho) {
        return repository.findById(id).map(trabalhoExistente -> {
            trabalhoExistente.setTitulo(novoTrabalho.getTitulo());
            trabalhoExistente.setDescricao(novoTrabalho.getDescricao());
            trabalhoExistente.setDataEntrega(novoTrabalho.getDataEntrega());
            trabalhoExistente.setDisciplina(novoTrabalho.getDisciplina());
            trabalhoExistente.setStatus(novoTrabalho.getStatus());
            return repository.save(trabalhoExistente);
        }).orElseThrow(() -> new RuntimeException("Trabalho não encontrado" + id));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho não encontrado " + id);
        }
        repository.deleteById(id);
    }
}
