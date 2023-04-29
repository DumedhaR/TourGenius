package com.codemind.tourgenius.service;

import com.codemind.tourgenius.model.Room;

import java.util.List;

public interface RoomService {

    Room create(Room room);
    Room findById(Long id);
    Room update(Room room);
    List<Room> findAll();
    Long delete(Room room);
;

}
