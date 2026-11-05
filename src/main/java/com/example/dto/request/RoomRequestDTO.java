package com.example.dto.request;

import com.example.entity.RoomType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomRequestDTO {
    @NotBlank
    private String roomNumber;

    @NotBlank
    private RoomType roomType;

    private String description;

    @NotBlank
    private BigDecimal pricePerNight;

    private int capacity;

    @NotBlank
    private boolean available;
}
