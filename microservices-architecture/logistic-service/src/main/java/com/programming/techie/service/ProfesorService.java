package com.programming.techie.service;

import com.programming.techie.controller.request.ProfesorRequest;
import com.programming.techie.controller.response.ProfesorResponse;
import com.programming.techie.repository.ProfesorRepository;
import com.programming.techie.repository.model.Profesor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfesorService {

  private final ProfesorRepository profesorRepository;

  public ProfesorResponse createProfesor(ProfesorRequest profesorRequest) {
    var profesor = toEntity(profesorRequest);
    profesorRepository.save(profesor);
    return ProfesorResponse.builder()
      .id(profesor.getId())
      .email(profesor.getCorreo())
      .idUsuario(profesor.getIdUsuario())
      .build();
  }
  public ProfesorResponse getProfesorByUserId(Long userId) {
    var profesor = profesorRepository.findByIdUsuario(userId).orElseThrow();
    return ProfesorResponse.builder()
      .id(profesor.getId())
      .email(profesor.getCorreo())
      .idUsuario(profesor.getIdUsuario())
      .build();
  }

  private Profesor toEntity(ProfesorRequest request) {
    return Profesor.builder()
      .correo(request.getEmail())
      .idUsuario(request.getIdUsuario())
      .build();
  }
}