package br.com.unisales.trabalhos_academicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unisales.trabalhos_academicos.model.TrabalhoAcademico;

@Repository
public interface TrabalhoRepository extends JpaRepository<TrabalhoAcademico, Long> {
}
