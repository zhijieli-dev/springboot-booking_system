package com.example.controller;

import com.example.dto.request.RegisterRequestDTO;
import com.example.dto.request.LoginRequestDTO;
import com.example.dto.response.LoginResponseDTO;
import com.example.dto.response.RegisterResponseDTO;
import com.example.entity.User;
import com.example.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        User user = authService.register(request);

        RegisterResponseDTO response = new RegisterResponseDTO();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setRoles(
                user.getRoles().stream()
                        .map(role -> role.getName())
                        .toList()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}