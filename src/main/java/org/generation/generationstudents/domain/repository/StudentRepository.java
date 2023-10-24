package org.generation.generationstudents.domain.repository;

import org.generation.generationstudents.domain.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Estudante,Long> {

    List<Estudante> findByNomeContainingIgnoreCase(String nome);
    List<Estudante> findByProfessoresNameContainingIgnoreCase(String nome);
    List<Estudante> findByNumeroSalaContainingIgnoreCase(String number);
}
