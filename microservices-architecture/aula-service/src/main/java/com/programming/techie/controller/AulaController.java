package com.programming.techie.controller;

import com.programming.techie.controller.request.AulaRequest;
import com.programming.techie.controller.response.AulaResponse;
import com.programming.techie.service.AulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aula-service/aula")
@RequiredArgsConstructor
public class AulaController {

  private final AulaService aulaService;


  @PostMapping
  public ResponseEntity<AulaResponse> createAula(@RequestBody AulaRequest request) {
    return ResponseEntity.ok(aulaService.createAula(request));
  }

  @GetMapping
  public ResponseEntity<List<AulaResponse>> getAllAulas() {
    return ResponseEntity.ok(aulaService.getAll());
  }
}