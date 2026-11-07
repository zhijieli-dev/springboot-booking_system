package com.example.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class RegisterResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
}
