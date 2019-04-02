package com.thanglv.sprnonblocking.services;

import com.thanglv.sprnonblocking.entity.Room;
import com.thanglv.sprnonblocking.repository.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

  @Autowired
  private RoomRepository roomRepository;

  public Room createRoom(Room room) {
    return roomRepository.save(room);
  }

  public Optional<Room> findByRoomCode(Integer roomCode) {
    return roomRepository.findByRoomCode(roomCode);
  }

  public List<Room> findAllRoom() {
    return roomRepository.findAll();
  }

  public List<Room> findByIsActive(Boolean isActive) {
    return roomRepository.findAllByIsActiveOrderByRoomIdDesc(isActive);
  }
}
