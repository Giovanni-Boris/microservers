package com.programming.techie.controller;

import com.programming.techie.controller.request.AlumnoRequest;
import com.programming.techie.controller.request.ProfesorRequest;
import com.programming.techie.controller.response.AlumnoResponse;
import com.programming.techie.controller.response.ProfesorResponse;
import com.programming.techie.service.AlumnoService;
import com.programming.techie.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client/alumno")
@RequiredArgsConstructor
public class AlumnoController {

  private final AlumnoService alumnoService;

  @PostMapping
  public ResponseEntity<AlumnoResponse> createProfesor(@RequestBody AlumnoRequest request) {
    return ResponseEntity.ok(alumnoService.createAlumno(request));
  }
  @GetMapping("/{userId}")
  public ResponseEntity<AlumnoResponse> getAlumnoByUserId(@PathVariable Long userId) {
    return ResponseEntity.ok(alumnoService.getAlumnoByUserId(userId));
  }
}