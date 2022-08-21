package com.example.etorobackend.controllers;

import com.example.etorobackend.models.BlushResponse;
import com.example.etorobackend.models.JwtRequest;
import com.example.etorobackend.models.JwtResponse;
import com.example.etorobackend.services.UserService;
import com.example.etorobackend.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public LoginController(UserService userService,
                           AuthenticationManager authenticationManager,
                           JwtUtils jwtUtils) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody JwtRequest jwtRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()

                    )
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new BlushResponse("Invalid password or username"));
        }
        UserDetails userDetails = userService.loadUserByUsername((jwtRequest.getUsername()));
        String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok().body(new JwtResponse(token));
    }
}
