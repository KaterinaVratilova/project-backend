package com.example.etorobackend.assets.controllers;

import com.example.etorobackend.assets.exceptions.AssetNotFoundException;
import com.example.etorobackend.assets.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
