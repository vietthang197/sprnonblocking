package com.thanglv.sprnonblocking.controller;

import com.thanglv.sprnonblocking.entity.Message;
import com.thanglv.sprnonblocking.entity.Room;
import com.thanglv.sprnonblocking.model.DataMessage;
import static java.lang.String.format;

import com.thanglv.sprnonblocking.services.MessageService;
import com.thanglv.sprnonblocking.services.RoomService;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

  @Autowired
  private SimpMessageSendingOperations messagingTemplate;

  @Autowired
  private RoomService roomService;

  @Autowired
  private MessageService messageService;

  @MessageMapping("/hello/{roomCode}/{roomName}/{username}")
  public void sendMessage(@DestinationVariable String roomCode, @DestinationVariable String roomName, @DestinationVariable String username, @Payload DataMessage message) {
    Room roomCreate = null;
    Optional<Room> roomOptional = roomService.findByRoomCode(Integer.parseInt(roomCode));
    if (!roomOptional.isPresent()) {
      roomCreate = new Room();
      roomCreate.setRoomCode(Integer.parseInt(roomCode));
      roomCreate.setIsActive(true);
      roomCreate.setRoomName(roomName);
      roomService.createRoom(roomCreate);
    }  else {
      roomCreate = roomOptional.get();
    }
    if (roomCreate.getRoomId() != null) {
      System.out.println(message.getType());
      Message messageCreate = new Message();
      messageCreate.setDateComment(new Date());
      messageCreate.setMessageText(message.getMessage());
      messageCreate.setRoomId(roomCreate.getRoomId());
      messageCreate.setUsername(username);
      messageCreate.setType(message.getType());
      messageService.createMessage(messageCreate);
    }

    messagingTemplate.convertAndSend(format("/topic/greetings/%s", roomCode), message);
  }
}