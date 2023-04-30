package com.codemind.tourgenius.service.impl;

import com.codemind.tourgenius.model.Room;
import com.codemind.tourgenius.repository.RoomRepository;
import com.codemind.tourgenius.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;


    @Override
    public Room create(Room room) {
        Room persistedRoom = roomRepository.save(room);
        return persistedRoom;
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public Room update(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Long delete(Room room) {
        roomRepository.delete(room);
        return room.getId();
    }
}
