package com.example.etorobackend.auth.controllers;

import com.example.etorobackend.auth.models.ErrorResponse;
import com.example.etorobackend.auth.models.JwtRequest;
import com.example.etorobackend.auth.models.JwtResponse;
import com.example.etorobackend.common.codes.ErrorCodes;
import com.example.etorobackend.users.entities.UserEntity;
import com.example.etorobackend.users.services.UserService;
import com.example.etorobackend.auth.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path ="api/v1")
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
    @PostMapping("/auth")
    public ResponseEntity<Object> login(@RequestBody @Valid JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.email(),
                            jwtRequest.password()
                    )
            );
        } catch (InternalAuthenticationServiceException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse(
                            e.getMessage(),
                            ErrorCodes.BAD_CREDENTIALS,
                            HttpStatus.UNAUTHORIZED.value()
                    ));
        }

        UserEntity userDetails = userService.findUserByEmail(jwtRequest.email());
        String token = jwtUtils.generateToken(userDetails);
        String refreshToken = jwtUtils.generateRefreshToken(userDetails);

        return ResponseEntity.ok().body(new JwtResponse(
                token,
                refreshToken,
                userService.getUserResponse(userDetails)));
    }
}
