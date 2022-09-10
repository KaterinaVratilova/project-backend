package com.example.etorobackend.users.services;

import com.example.etorobackend.users.entities.UserEntity;
import com.example.etorobackend.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserGetService {
    private final UserRepository userRepository;

    @Autowired
    public UserGetService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(UUID id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("User not found [%s]", id)));
    }
}
