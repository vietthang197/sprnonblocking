package com.thanglv.sprnonblocking.repository;

import com.thanglv.sprnonblocking.entity.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
  Optional<Room> findByRoomCode(Integer roomCode);
  List<Room> findAllByIsActiveOrderByRoomIdDesc(Boolean isActive);
}
