package br.com.unisales.trabalhos_academicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.trabalhos_academicos.model.Universitario;
import br.com.unisales.trabalhos_academicos.repository.UniversitarioRepository;

@Service
public class UniversitarioService {

    @Autowired
    private UniversitarioRepository repository;

    public List<Universitario> findAll() {
        return repository.findAll();
    }

    public Optional<Universitario> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Universitario> login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }
}
