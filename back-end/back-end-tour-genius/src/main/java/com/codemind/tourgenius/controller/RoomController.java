package com.codemind.tourgenius.controller;

import com.codemind.tourgenius.dto.request.RoomCreateRequest;
import com.codemind.tourgenius.dto.response.RoomSearchResponse;
import com.codemind.tourgenius.model.Room;
import com.codemind.tourgenius.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("${app.endpoint.roomCreate}")
    public String saveRoom(@RequestBody RoomCreateRequest request){
        Room room =  new Room();
        room.setId(request.getId());
        room.setPrice(request.getPrice());
        room.setSize(request.getSize());
        room.setRoomDesc(request.getRoomDesc());
        room.setType(request.getType());
        roomService.create(room);
        return "room Added";
    }


    @PutMapping ("${app.endpoint.roomUpdate}")
    public String updateRoom(@PathVariable("id") String roomId,@RequestBody RoomCreateRequest request){
        Room room = roomService.findById(Long.valueOf(roomId));
        room.setPrice(request.getPrice());
        room.setSize(request.getSize());
        room.setRoomDesc(request.getRoomDesc());
        room.setType(request.getType());
        roomService.update(room);
        return "room data Updated";
    }


    @GetMapping("${app.endpoint.roomSearch}")
    public List<RoomSearchResponse> search() {
        List<RoomSearchResponse> roomSearchResponseList =  new ArrayList<>();
        List<Room> rooms = roomService.findAll();
        for(Room room :rooms){
            RoomSearchResponse response = new RoomSearchResponse();
            response.setId(room.getId());
            response.setPrice(room.getPrice());
            response.setSize(room.getSize());
            response.setRoomDesc(room.getRoomDesc());
            response.setType(room.getType());
            roomSearchResponseList.add(response);
        }

        return roomSearchResponseList;
    }

    @GetMapping ("${app.endpoint.roomView}")
    public RoomSearchResponse updateRoom(@PathVariable("id") String roomId) {
        Room room = roomService.findById(Long.valueOf(roomId));
        RoomSearchResponse response = new RoomSearchResponse();
        response.setId(room.getId());
        response.setPrice(room.getPrice());
        response.setSize(room.getSize());
        response.setRoomDesc(room.getRoomDesc());
        response.setType(room.getType());

        return response;
    }

    @DeleteMapping ("${app.endpoint.roomDelete}")
    public String deleteRoom(@PathVariable("id") String roomId) {
        Room room = roomService.findById(Long.valueOf(roomId));
        if(room!=null){
            roomService.delete(room);

            return "room data deleted ";
        }

        return "room data not deleted";

    }
}
