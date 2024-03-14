package com.programming.techie.controller;

import com.programming.techie.controller.request.ProfesorRequest;
import com.programming.techie.controller.response.AlumnoResponse;
import com.programming.techie.controller.response.ProfesorResponse;
import com.programming.techie.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client/profesor")
@RequiredArgsConstructor
public class ProfesorController {

  private final ProfesorService profesorService;

  @PostMapping
  public ResponseEntity<ProfesorResponse> createProfesor(@RequestBody ProfesorRequest request) {
    return ResponseEntity.ok(profesorService.createProfesor(request));
  }
  @GetMapping("/{userId}")
  public ResponseEntity<ProfesorResponse> getAlumnoByUserId(@PathVariable Long userId) {
    return ResponseEntity.ok(profesorService.getProfesorByUserId(userId));
  }
}