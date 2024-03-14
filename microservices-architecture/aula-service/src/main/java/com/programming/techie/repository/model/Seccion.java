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
@Table(name = "SECCION")
public class Seccion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdSeccion", nullable = false)
  private Long id;

  @Column(name = "NombreSeccion", length = Integer.MAX_VALUE)
  private String nombreSeccion;

  @OneToMany(mappedBy = "idSeccion")
  private Set<Aula> aulas = new LinkedHashSet<>();

}