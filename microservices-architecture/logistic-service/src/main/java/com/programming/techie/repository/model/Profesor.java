package com.programming.techie.repository.model;

import lombok.*;

import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROFESOR")
public class Profesor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdProfesor", nullable = false)
  private Long id;

  @Column(name = "Correo")
  private String correo;

  private Long idUsuario;

}