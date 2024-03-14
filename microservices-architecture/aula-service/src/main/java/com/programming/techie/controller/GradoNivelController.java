package com.programming.techie.controller;

import com.programming.techie.controller.response.GradoNivelResponse;
import com.programming.techie.service.GradoNivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aula-service/grado-nivel")
@RequiredArgsConstructor
public class GradoNivelController {

  private final GradoNivelService gradoNivelService;


  @GetMapping
  public ResponseEntity<List<GradoNivelResponse>> getAllAulas() {
    return ResponseEntity.ok(gradoNivelService.getAllGradosNiveles());
  }
}