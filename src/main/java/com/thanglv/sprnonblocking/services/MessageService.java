package com.thanglv.sprnonblocking.services;

import com.thanglv.sprnonblocking.entity.Message;
import com.thanglv.sprnonblocking.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired
  private MessageRepository messageRepository;

  public Message createMessage(Message message) {
    return messageRepository.save(message);
  }

  public List<Message> findListMessageByRoomId(Integer roomId) {
    return messageRepository.findAllByRoomIdOrderByDateComment(roomId);
  }
}
