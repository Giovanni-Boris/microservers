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
@Table(name = "NIVEL")
public class Nivel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdNivel", nullable = false)
  private Long id;

  @Column(name = "Nivel", length = Integer.MAX_VALUE)
  private String nivel;

  @OneToMany(mappedBy = "idNivel")
  private Set<GradoNivel> gradoNivels = new LinkedHashSet<>();

}