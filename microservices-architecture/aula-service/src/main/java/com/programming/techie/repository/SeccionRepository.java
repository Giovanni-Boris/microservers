package com.programming.techie.repository;

import com.programming.techie.repository.model.Grado;
import com.programming.techie.repository.model.GradoNivel;
import com.programming.techie.repository.model.Nivel;
import com.programming.techie.repository.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeccionRepository extends JpaRepository<Seccion, Long> {
}