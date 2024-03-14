package com.programming.techie.service;

import com.programming.techie.controller.request.AulaRequest;
import com.programming.techie.controller.response.*;
import com.programming.techie.repository.AulaRepository;
import com.programming.techie.repository.GradoNivelRepository;
import com.programming.techie.repository.SeccionRepository;
import com.programming.techie.repository.model.Aula;
import com.programming.techie.repository.model.Grado;
import com.programming.techie.repository.model.Nivel;
import com.programming.techie.repository.model.Seccion;
import com.programming.techie.service.exception.AulaAlreadyTakenExepction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AulaService {

  private final AulaRepository aulaRepository;
  private final GradoNivelRepository gradoNivelRepository;
  private final SeccionRepository seccionRepository;

  public AulaResponse createAula(AulaRequest request) {
    var grado_search = Grado.builder()
      .id(request.getIdGrado())
      .build();
    var nivel_search = Nivel.builder()
      .id(request.getIdNivel())
      .build();
    var gradoNivel = gradoNivelRepository.findByIdGradoAndIdNivel(grado_search,nivel_search )
      .orElseThrow();
    var seccion = seccionRepository.findById(request.getIdSeccion())
      .orElseThrow();
    var aula_exists = aulaRepository.findByIdGradoNivelAndIdSeccion(gradoNivel, seccion);
    if(aula_exists.isPresent()){
      throw new AulaAlreadyTakenExepction("Try again");
    }
      var aula = Aula.builder()
      .nombre(request.getNombre())
      .capacidad(request.getCapacidad())
      .ubicacion(request.getUbicacion())
      .idGradoNivel(gradoNivel)
      .idSeccion(seccion)
      .build();
    aula = aulaRepository.save(aula);
    return toAulaResponse(aula);
  }
  public List<AulaResponse> getAll() {
    List<Aula> aulas = aulaRepository.findAll();
    return aulas.stream().map(this::toAulaResponse).collect(Collectors.toList());
  }


  public AulaResponse toAulaResponse(Aula aula) {
    return AulaResponse.builder()
      .id(aula.getId())
      .nombre(aula.getNombre())
      .capacidad(aula.getCapacidad())
      .ubicacion(aula.getUbicacion())
      .grado_nivel(GradoNivelResponse.builder()
        .grado(toGradoResponse(aula.getIdGradoNivel().getIdGrado()))
        .nivel(toNivelResponse(aula.getIdGradoNivel().getIdNivel()))
        .build()
      )
      .seccion(toSeccionResponse(aula.getIdSeccion()))
      .build();
  }

  private GradoResponse toGradoResponse(Grado grado) {
    return GradoResponse.builder()
      .id(grado.getId())
      .numGrado(grado.getNumGrado())
      .build();
  }

  private NivelResponse toNivelResponse(Nivel nivel) {
    return NivelResponse.builder()
      .id(nivel.getId())
      .nivel(nivel.getNivel())
      .build();
  }

  private SeccionResponse toSeccionResponse(Seccion seccion) {
    return SeccionResponse.builder()
      .id(seccion.getId())
      .nombreSeccion(seccion.getNombreSeccion())
      .build();
  }
}