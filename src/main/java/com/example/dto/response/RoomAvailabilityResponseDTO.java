package com.example.dto.response;

import lombok.Data;

@Data
public class RoomAvailabilityResponseDTO {
    private Long id;
    private String roomNumber;
    private boolean available;
}
