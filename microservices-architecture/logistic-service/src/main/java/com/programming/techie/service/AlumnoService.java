package com.programming.techie.service;

import com.programming.techie.controller.request.AlumnoRequest;
import com.programming.techie.controller.response.AlumnoResponse;
import com.programming.techie.repository.AlumnoRepository;
import com.programming.techie.repository.model.Alumno;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlumnoService {

  private final AlumnoRepository alumnoRepository;
  public AlumnoResponse createAlumno(AlumnoRequest alumnoRequest) {
    var alumno = toEntity(alumnoRequest);
    var savedAlumno = alumnoRepository.save(alumno);
    return AlumnoResponse.builder()
      .id(savedAlumno.getId())
      .address(savedAlumno.getDireccion())
      .birthday(savedAlumno.getFechaDeNacimiento())
      .idUsuario(savedAlumno.getIdUsuario())
      .build();
  }
  public AlumnoResponse getAlumnoByUserId(Long userId) {
    var alumno = alumnoRepository.findByIdUsuario(userId).orElseThrow();
    return AlumnoResponse.builder()
      .id(alumno.getId())
      .address(alumno.getDireccion())
      .birthday(alumno.getFechaDeNacimiento())
      .idUsuario(alumno.getIdUsuario())
      .build();
  }
  private Alumno toEntity(AlumnoRequest request) {
    return Alumno.builder()
      .direccion(request.getAddress())
      .fechaDeNacimiento(request.getBirthday())
      .idUsuario(request.getIdUsuario())
      .build();
  }
}
