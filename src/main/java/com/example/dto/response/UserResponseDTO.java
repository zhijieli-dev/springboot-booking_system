package com.example.dto.response;

import com.example.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Role> roles;
}
