package com.example.etorobackend.auth.controllers;

import com.example.etorobackend.auth.models.ErrorResponse;
import com.example.etorobackend.common.codes.ErrorCodes;
import com.example.etorobackend.users.model.RegisterRequest;
import com.example.etorobackend.users.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Tag(name = "User")
@RestController
@RequestMapping(path ="api/v1")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterRequest registerRequest) throws Exception {
        try {
            userService.saveUser(registerRequest);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(
                    String.format("User [%s] already exists", registerRequest.getEmail()),
                    ErrorCodes.USER_DUPLICATION,
                    HttpStatus.CONFLICT.value()
            ));
        }
    }
}
