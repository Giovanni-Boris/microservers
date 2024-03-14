package com.programming.techie.repository;

import com.programming.techie.repository.model.Grado;
import com.programming.techie.repository.model.GradoNivel;
import com.programming.techie.repository.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradoNivelRepository extends JpaRepository<GradoNivel, Long> {
  Optional<GradoNivel> findByIdGradoAndIdNivel(Grado idGrado, Nivel idNivel);
}