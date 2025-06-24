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

import br.com.unisales.trabalhos_academicos.model.Universitario;
import br.com.unisales.trabalhos_academicos.service.UniversitarioService;

@RestController
@RequestMapping("/universitarios")
@CrossOrigin
public class UniversitarioController {

    @Autowired
    private UniversitarioService service;

    @GetMapping
    public List<Universitario> listarTodos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universitario> buscarPorId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<Universitario> login(@PathVariable String email, @PathVariable String senha) {
        return service.login(email, senha)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    @PostMapping("/cadastrar")
    public Universitario cadastrar(@RequestBody Universitario universitario) {
        return service.salvar(universitario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universitario> atualizar(@PathVariable Long id, @RequestBody Universitario universitario) {
        try {
            Universitario atualizado = service.atualizar(id, universitario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
