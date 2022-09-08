package com.example.etorobackend.assets.controllers;

import com.example.etorobackend.assets.exceptions.AssetNotFoundException;
import com.example.etorobackend.assets.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/assets/{name}")
//    public ResponseEntity<Object> getAsset(@PathVariable String name) throws AssetNotFoundException {
//        var asset = assetService.get(name);
//
//        return ResponseEntity.ok().body(asset);
//    }

    @GetMapping("/assets/{id}")
    public ResponseEntity<Object> getAsset(@PathVariable UUID id) throws AssetNotFoundException {
        var asset = assetService.get(id);

        return ResponseEntity.ok().body(asset);
    }
}
