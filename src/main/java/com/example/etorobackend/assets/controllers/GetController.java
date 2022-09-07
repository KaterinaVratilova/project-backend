package com.example.etorobackend.assets.controllers;

import com.example.etorobackend.assets.exceptions.AssetNotFoundException;
import com.example.etorobackend.assets.services.AssetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Assets")
@RestController
@RequestMapping("/api/v1")
public class GetController {

    private final AssetService assetService;

    @Autowired
    public GetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/assets")
    public ResponseEntity<Object> getAll() {
        var assets = assetService.getAll();

        return ResponseEntity.ok().body(assets);
    }
}
