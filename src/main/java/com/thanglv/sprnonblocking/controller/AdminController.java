package com.thanglv.sprnonblocking.controller;

import com.thanglv.sprnonblocking.entity.Message;
import com.thanglv.sprnonblocking.entity.Room;
import com.thanglv.sprnonblocking.services.MessageService;
import com.thanglv.sprnonblocking.services.RoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/handler")
public class AdminController {

  @Autowired
  private RoomService roomService;

  @Autowired
  private MessageService messageService;

  @GetMapping
  public ModelAndView handleMessage(ModelAndView modelAndView) {
    modelAndView.setViewName("handleMessage");
    List<Room> roomList = roomService.findByIsActive(true);
    modelAndView.addObject("roomList", roomList);
    return modelAndView;
  }

  @GetMapping("/reply/{roomCode}/{roomId}/{roomName}")
  public ModelAndView replyMessage(@PathVariable(name = "roomCode") String roomCode, @PathVariable(name = "roomId") String roomId, @PathVariable(name = "roomName") String roomName,  ModelAndView modelAndView) {
    modelAndView.setViewName("replyMessage");
    modelAndView.addObject("roomCode", roomCode);
    modelAndView.addObject("roomName", roomName);

    List<Message> messageList = messageService.findListMessageByRoomId(Integer.parseInt(roomId));
    modelAndView.addObject("messageList", messageList);
    return modelAndView;
  }
}
