package com.blunt.metrics.dto;

import com.blunt.metrics.serializer.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.Map;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class MetricsDto {
  @JsonSerialize(using = ObjectIdSerializer.class)
  private ObjectId bluntId;
  private Integer totalPost;
  private ArrayList<ArrayList<String>> monthlyPost;
  private Integer totalFollowers;
  private Integer totalFollowings;
  private ArrayList<ArrayList<String>> monthlyFollowers;

}
