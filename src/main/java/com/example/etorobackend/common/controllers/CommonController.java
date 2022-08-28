package com.example.etorobackend.common.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class CommonController {
    @GetMapping("/")
    public String dashboard() {
        return "Api is ready";
    }
}
