package com.programming.techie.controller;

import com.programming.techie.controller.response.SeccionResponse;
import com.programming.techie.service.SeccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aula-services/secciones")
@RequiredArgsConstructor
public class SeccionController {

  private final SeccionService seccionService;
  @GetMapping
  public ResponseEntity<List<SeccionResponse>> getAllSecciones() {
    return ResponseEntity.ok(seccionService.getAllSecciones());
  }
}