package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookingStatusRequestDTO {
    @NotBlank
    private String status;
}
