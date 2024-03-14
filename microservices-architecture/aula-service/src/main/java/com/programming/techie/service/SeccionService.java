package com.programming.techie.service;

import com.programming.techie.controller.response.SeccionResponse;
import com.programming.techie.repository.SeccionRepository;
import com.programming.techie.repository.model.Seccion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeccionService {

  private final SeccionRepository seccionRepository;

  public List<SeccionResponse> getAllSecciones() {
    var secciones = seccionRepository.findAll();
    return secciones.stream()
      .map(this::toSeccionResponse)
      .collect(Collectors.toList());
  }

  private SeccionResponse toSeccionResponse(Seccion seccion) {
    return SeccionResponse.builder()
      .id(seccion.getId())
      .nombreSeccion(seccion.getNombreSeccion())
      .build();
  }
}
