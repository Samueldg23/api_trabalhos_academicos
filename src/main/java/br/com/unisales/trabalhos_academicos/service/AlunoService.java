package br.com.unisales.trabalhos_academicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.trabalhos_academicos.model.Aluno;
import br.com.unisales.trabalhos_academicos.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Aluno> login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }
    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }
    public Optional<Aluno> update(Long id, Aluno aluno) {
        return repository.findById(id).map(alunoExistente -> {
            alunoExistente.setNome(aluno.getNome());
            alunoExistente.setEmail(aluno.getEmail());
            alunoExistente.setSenha(aluno.getSenha());
            return repository.save(alunoExistente);
        });
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
