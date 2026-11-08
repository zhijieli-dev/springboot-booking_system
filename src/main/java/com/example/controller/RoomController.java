package com.example.controller;

import com.example.dto.request.RoomRequestDTO;
import com.example.dto.response.RoomResponseDTO;
import com.example.entity.Room;
import com.example.repository.RoomRepository;
import com.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomResponseDTO> createRoom(@RequestBody RoomRequestDTO roomRequestDTO) {
        Room room = roomService.createRoom(roomRequestDTO);

        RoomResponseDTO roomResponseDTO = new RoomResponseDTO();
        roomResponseDTO.setId(room.getId());
        roomResponseDTO.setRoomNumber(room.getRoomNumber());
        roomResponseDTO.setRoomType(room.getRoomType());
        roomResponseDTO.setDescription(room.getDescription());
        roomResponseDTO.setPricePerNight(room.getPricePerNight());
        roomResponseDTO.setCapacity(room.getCapacity());
        roomResponseDTO.setAvailable(room.isAvailable());

        return ResponseEntity.ok(roomResponseDTO);
    }

}
