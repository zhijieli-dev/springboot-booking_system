package com.example.dto.response;

import com.example.entity.BookingStatus;
import lombok.Data;

@Data
public class BookingStatusResponseDTO {
    private Long id;
    private BookingStatus status;
}
