package com.example.service;

import com.example.dto.request.RoomRequestDTO;
import com.example.dto.response.RoomResponseDTO;
import com.example.entity.Room;
import com.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(RoomRequestDTO roomRequestDTO) {
        Room room = Room.builder()
                .roomNumber(roomRequestDTO.getRoomNumber())
                .roomType(roomRequestDTO.getRoomType())
                .description(roomRequestDTO.getDescription())
                .pricePerNight(roomRequestDTO.getPricePerNight())
                .capacity(roomRequestDTO.getCapacity())
                .available(roomRequestDTO.isAvailable())
                .build();
        return roomRepository.save(room);
    }
}
