package com.example.dto.response;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private String tokenType;
}
