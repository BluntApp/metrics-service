package com.blunt.metrics.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "follow-service")
public interface FollowServiceProxyClient {
  @GetMapping("/api/v1/follow/metrics")
  public ResponseEntity<Object> getMetrics(
      @RequestHeader(name = "BLUNT-ID", required = true) String bluntId) ;
}



