package com.example.etorobackend.users.services;

import com.example.etorobackend.roles.entities.RoleEntity;
import com.example.etorobackend.roles.repositories.RoleRepository;
import com.example.etorobackend.users.entities.UserEntity;
import com.example.etorobackend.users.model.RegisterRequest;
import com.example.etorobackend.users.model.UserResponse;
import com.example.etorobackend.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity findById(UUID id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("User not found [%s]", id)));
    }

    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional(rollbackOn = Exception.class)
    public UserEntity saveUser(RegisterRequest registerRequest) throws Exception {
        try {
            UserEntity user = new UserEntity();

            user.setEmail(registerRequest.getEmail());
            user.setActive(true);
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            RoleEntity userRole = roleRepository.findByRole("USER_BASIC");
            user.setRoles(new HashSet<RoleEntity>(Collections.singletonList(userRole)));
            return userRepository.save(user);
        } catch (Exception e) {
            throw new Error(String.format("User was not created %s %s", registerRequest.getEmail(), e.getClass()));
        }
    }

    public UserResponse getUserResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getId(),
                userEntity.getRoles()
        );
    }
}
