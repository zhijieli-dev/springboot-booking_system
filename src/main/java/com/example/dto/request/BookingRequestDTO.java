package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDTO {
    @NotBlank
    private Long roomId;

    @NotBlank
    private LocalDate checkIn;

    @NotBlank
    private LocalDate checkOut;
}
