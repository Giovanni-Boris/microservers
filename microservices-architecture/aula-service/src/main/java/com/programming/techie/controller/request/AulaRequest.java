package com.programming.techie.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AulaRequest {
  private String nombre;
  private String capacidad;
  private String ubicacion;
  private Long idGrado;
  private Long idNivel;
  private Long idSeccion;
}