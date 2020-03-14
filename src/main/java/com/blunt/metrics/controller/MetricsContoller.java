package com.blunt.metrics.controller;

import com.blunt.metrics.service.MetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/metrics")
public class MetricsContoller {

  private final MetricsService metricsService;

  @GetMapping("test")
  public ResponseEntity<Object> testService() {
    return new ResponseEntity<>("Success", HttpStatus.OK);
  }

  @GetMapping("/blunt")
  public ResponseEntity<Object> getMetrics(@RequestHeader(name = "BLUNT-ID", required = true) String bluntId) {
    return metricsService.getMetrics(bluntId);
  }
}
