package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoomAvailabilityRequestDTO {
    @NotBlank
    private boolean available;
}
