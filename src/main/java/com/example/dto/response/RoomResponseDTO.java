package com.example.dto.response;

import com.example.entity.RoomType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomResponseDTO {
    private Long id;
    private String roomNumber;
    private RoomType roomType;
    private String description;
    private BigDecimal pricePerNight;
    private int capacity;
    private boolean available;
}
