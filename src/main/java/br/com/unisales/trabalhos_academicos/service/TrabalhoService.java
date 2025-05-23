package br.com.unisales.trabalhos_academicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.trabalhos_academicos.model.TrabalhoAcademico;
import br.com.unisales.trabalhos_academicos.repository.AlunoRepository;
import br.com.unisales.trabalhos_academicos.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<TrabalhoAcademico> findAll() {
        return repository.findAll();
    }

    public Optional<TrabalhoAcademico> findById(Long id) {
        return repository.findById(id);
    }

    public List<TrabalhoAcademico> listarPorAluno(Long alunoId) {
        return repository.findByAlunoId(alunoId);
    }

    public Optional<TrabalhoAcademico> create(TrabalhoAcademico trabalho, long alunoId) {
        return alunoRepository.findById(alunoId).map(aluno -> {
            trabalho.setAluno(aluno);
            return repository.save(trabalho);
        });
    }
    public Optional<TrabalhoAcademico> update(Long id, TrabalhoAcademico trabalhoAtualizado) {
        return repository.findById(id).map(trabalhoExistente -> {
            trabalhoExistente.setTitulo(trabalhoAtualizado.getTitulo());
            trabalhoExistente.setDescricao(trabalhoAtualizado.getDescricao());
            trabalhoExistente.setDataEntrega(trabalhoAtualizado.getDataEntrega());
            trabalhoExistente.setDisciplina(trabalhoAtualizado.getDisciplina());
            trabalhoExistente.setStatus(trabalhoAtualizado.getStatus());
            return repository.save(trabalhoExistente);
        });
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
