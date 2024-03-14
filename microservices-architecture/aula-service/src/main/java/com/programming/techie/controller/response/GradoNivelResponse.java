package com.programming.techie.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradoNivelResponse {
  private GradoResponse grado;
  private NivelResponse nivel;
}
