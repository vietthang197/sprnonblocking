package com.thanglv.sprnonblocking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataMessage {
  private String message;
  private String type;
}
