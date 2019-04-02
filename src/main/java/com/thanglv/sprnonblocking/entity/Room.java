package com.thanglv.sprnonblocking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity(name = "room")
@Table(name = "room")
@Data
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer roomId;

  @Column(name = "room_code")
  private Integer roomCode;

  @Column(name = "room_name")
  private String roomName;

  @Column(name = "is_active")
  private Boolean isActive;
}
