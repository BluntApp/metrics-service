package com.blunt.metrics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/metrics")
public class MetricsContoller {

  @GetMapping("test")
  public ResponseEntity<Object> testService() {
    return new ResponseEntity<>("Success", HttpStatus.OK);
  }
}
