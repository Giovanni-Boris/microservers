package com.programming.techie.repository;

import com.programming.techie.repository.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AulaRepository extends JpaRepository<Aula, Long> {
  Optional<Aula> findByIdGradoNivelAndIdSeccion(GradoNivel idGrado, Seccion seccion);
}