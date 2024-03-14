package com.programming.techie.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AulaResponse {
  private Long id;
  private String nombre;
  private String capacidad;
  private String ubicacion;
  private GradoNivelResponse grado_nivel;
  private SeccionResponse seccion;

}