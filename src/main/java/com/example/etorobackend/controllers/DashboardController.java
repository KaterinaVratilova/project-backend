package com.example.etorobackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class DashboardController {
    @GetMapping("/")
    public String dashboard() {
        return "Api is ready";
    }
}
