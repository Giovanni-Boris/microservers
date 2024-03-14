package com.programming.techie.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoResponse {
  private Long id;
  private String address;
  private LocalDate birthday;
  private Long idUsuario;
}
