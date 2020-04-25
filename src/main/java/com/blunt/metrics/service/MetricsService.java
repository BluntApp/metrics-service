package com.blunt.metrics.service;

import com.blunt.metrics.dto.MetricsDto;
import com.blunt.metrics.proxy.FollowServiceProxyClient;
import com.blunt.metrics.proxy.PublishServiceProxyClient;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetricsService {

  private final PublishServiceProxyClient publishServiceProxyClient;
  private final FollowServiceProxyClient followServiceProxyClient;

  public ResponseEntity<Object> getMetrics(String bluntId) {
    MetricsDto metricsDto = new MetricsDto();
    ResponseEntity<Object> publishMetricsResponseEntity = publishServiceProxyClient.getMetrics(bluntId);
    ResponseEntity<Object> followMetricsResponseEntity = followServiceProxyClient.getMetrics(bluntId);

    LinkedHashMap publisherMetricsBody = (LinkedHashMap) publishMetricsResponseEntity.getBody();
    LinkedHashMap followMetricsBody = (LinkedHashMap) followMetricsResponseEntity.getBody();

    metricsDto.setBluntId(new ObjectId(bluntId));
    metricsDto.setTotalPost((Integer) publisherMetricsBody.get("totalPost"));
    metricsDto.setMonthlyPost((ArrayList<ArrayList<String>>)publisherMetricsBody.get("monthlyPost"));
    metricsDto.setTotalFollowers((Integer)followMetricsBody.get("totalFollowers"));
    metricsDto.setTotalFollowings((Integer)followMetricsBody.get("totalFollowings"));
    metricsDto.setMonthlyFollowers(
        (ArrayList<ArrayList<String>>) followMetricsBody.get("monthlyFollowers"));
    return new ResponseEntity<>(metricsDto, HttpStatus.OK);
  }
}
