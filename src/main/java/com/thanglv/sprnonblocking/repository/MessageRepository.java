package com.thanglv.sprnonblocking.repository;

import com.thanglv.sprnonblocking.entity.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
  List<Message> findAllByRoomIdOrderByDateComment(Integer roomId);
}
