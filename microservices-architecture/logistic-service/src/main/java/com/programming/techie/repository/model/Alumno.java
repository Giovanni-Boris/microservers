package com.programming.techie.repository.model;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ALUMNO")
public class Alumno {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdEstudiante", nullable = false)
  @Id
  private Long id;

  @Column(name = "Direccion")
  private String direccion;

  @Column(name = "Fecha_de_Nacimiento")
  private LocalDate fechaDeNacimiento;

  private Long idUsuario;

}