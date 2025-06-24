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

    public List<TrabalhoAcademico> listarPorUniversitario(Long universitarioId) {
        return repository.findByUniversitarioId(universitarioId);
    }
    public TrabalhoAcademico salvar(TrabalhoAcademico trabalhoAcademico) {
        return repository.save(trabalhoAcademico);
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    public TrabalhoAcademico atualizar(Long id, TrabalhoAcademico trabalhoAcademico) {
        Optional<TrabalhoAcademico> trabalhoExistente = repository.findById(id);
        if (trabalhoExistente.isPresent()) {
            TrabalhoAcademico existente = trabalhoExistente.get();
            existente.setTitulo(trabalhoAcademico.getTitulo());
            existente.setDescricao(trabalhoAcademico.getDescricao());
            existente.setDataEntrega(trabalhoAcademico.getDataEntrega());
            existente.setDisciplina(trabalhoAcademico.getDisciplina());
            existente.setStatus(trabalhoAcademico.getStatus());
            existente.setUniversitario(trabalhoAcademico.getUniversitario());
            return repository.save(existente);
        } else {
            throw new RuntimeException("Trabalho acadêmico não encontrado com o ID: " + id);
        }
    }
}
