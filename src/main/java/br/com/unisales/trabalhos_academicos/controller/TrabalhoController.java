package br.com.unisales.trabalhos_academicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisales.trabalhos_academicos.model.TrabalhoAcademico;
import br.com.unisales.trabalhos_academicos.service.TrabalhoService;

@RestController
@RequestMapping("/trabalhos")
@CrossOrigin
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;

    @GetMapping
    public List<TrabalhoAcademico> listarTodos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoAcademico> buscarPorId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/aluno/{alunoId}")
    public List<TrabalhoAcademico> listarPorAluno(@PathVariable Long alunoId) {
        return service.listarPorAluno(alunoId);
    }
}
