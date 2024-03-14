package com.programming.techie.repository;

import com.programming.techie.repository.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
  Optional<Profesor> findByIdUsuario(Long idUsuario);
}
