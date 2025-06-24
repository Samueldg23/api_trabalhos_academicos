package br.com.unisales.trabalhos_academicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/universitario/{universitarioId}")
    public List<TrabalhoAcademico> listarPorUniversitario(@PathVariable Long universitarioId) {
        return service.listarPorUniversitario(universitarioId);
    }
    @PostMapping("/cadastrar")
    public TrabalhoAcademico cadastrar(@RequestBody TrabalhoAcademico trabalhoAcademico) {
        return service.salvar(trabalhoAcademico);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoAcademico> atualizar(@PathVariable Long id, @RequestBody TrabalhoAcademico trabalhoAcademico) {
        try {
            TrabalhoAcademico atualizado = service.atualizar(id, trabalhoAcademico);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
