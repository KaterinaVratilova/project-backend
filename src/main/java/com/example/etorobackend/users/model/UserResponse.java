package com.example.etorobackend.users.model;

import com.example.etorobackend.roles.entities.RoleEntity;

import java.util.Set;
import java.util.UUID;

public record UserResponse(String email, String firstname, String lastName, UUID id, Set<RoleEntity> roles) {
}
