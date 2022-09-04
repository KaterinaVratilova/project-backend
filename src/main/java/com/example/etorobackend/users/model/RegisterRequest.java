package com.example.etorobackend.users.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ToString
@NoArgsConstructor
public class RegisterRequest {
    @NotEmpty
    @Size(min=6, max=16, message = "Username must be between 6 and 16 characters long")
    private String username;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotEmpty
    @Size(min=8, max=100, message = "Password must be between 8 and 100 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
