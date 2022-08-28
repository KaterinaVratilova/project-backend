package com.example.etorobackend.auth.models;

import com.example.etorobackend.users.model.UserResponse;

public record JwtResponse(String jwtToken, String refreshToken, UserResponse user) {
}
