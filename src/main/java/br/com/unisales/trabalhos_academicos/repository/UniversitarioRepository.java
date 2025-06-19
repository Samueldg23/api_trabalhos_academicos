package br.com.unisales.trabalhos_academicos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.trabalhos_academicos.model.Universitario;

@Repository
public interface UniversitarioRepository extends JpaRepository<Universitario, Long> {
    Optional<Universitario> findByEmailAndSenha(String email, String senha);
}
