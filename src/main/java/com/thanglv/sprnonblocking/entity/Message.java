package com.thanglv.sprnonblocking.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "message")
@Table(name = "message")
@Data
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer messageId;

  @Column(name = "room_id")
  private Integer roomId;

  @Column(name = "message_text", length = 2000)
  private String messageText;

  @Column(name = "username")
  private String username;

  @Column(name = "date_comment")
  private Date dateComment;

  @Column(name = "type", length = 500)
  private String type;
}
