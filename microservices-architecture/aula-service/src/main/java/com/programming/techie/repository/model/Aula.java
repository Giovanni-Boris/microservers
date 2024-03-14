package com.programming.techie.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AULA")
public class Aula {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdAula", nullable = false)
  private Long id;

  @Column(name = "Nombre", length = Integer.MAX_VALUE)
  private String nombre;

  @Column(name = "Capacidad", length = Integer.MAX_VALUE)
  private String capacidad;

  @Column(name = "Ubicacion", length = Integer.MAX_VALUE)
  private String ubicacion;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "IdGradoNivel", nullable = false)
  private GradoNivel idGradoNivel;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "IdSeccion", nullable = false)
  private Seccion idSeccion;

}