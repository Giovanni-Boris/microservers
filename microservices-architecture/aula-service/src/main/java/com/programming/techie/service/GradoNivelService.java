package com.programming.techie.service;

import com.programming.techie.controller.response.GradoNivelResponse;
import com.programming.techie.controller.response.GradoResponse;
import com.programming.techie.controller.response.NivelResponse;
import com.programming.techie.repository.GradoNivelRepository;
import com.programming.techie.repository.model.GradoNivel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GradoNivelService {

  private final GradoNivelRepository gradoNivelRepository;

  public List<GradoNivelResponse> getAllGradosNiveles() {
    List<GradoNivel> gradoNiveles = gradoNivelRepository.findAll();
    return gradoNiveles.stream()
      .map(this::toGradoNivelResponse)
      .collect(Collectors.toList());
  }

  private GradoNivelResponse toGradoNivelResponse(GradoNivel gradoNivel) {
    return GradoNivelResponse.builder()
      .grado(GradoResponse.builder()
        .id(gradoNivel.getIdGrado().getId())
        .numGrado(gradoNivel.getIdGrado().getNumGrado())
        .build())
      .nivel(NivelResponse.builder()
        .id(gradoNivel.getIdNivel().getId())
        .nivel(gradoNivel.getIdNivel().getNivel())
        .build())
      .build();
  }
}
