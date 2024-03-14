package com.programming.techie.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoRequest {
  private String address;
  private LocalDate birthday;
  private Long idUsuario;;

}
