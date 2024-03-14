package com.programming.techie.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GRADO")
public class Grado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdGrado", nullable = false)
  private Long id;

  @Column(name = "NumGrado", length = Integer.MAX_VALUE)
  private String numGrado;

  @OneToMany(mappedBy = "idGrado")
  private Set<GradoNivel> gradoNivels = new LinkedHashSet<>();

}