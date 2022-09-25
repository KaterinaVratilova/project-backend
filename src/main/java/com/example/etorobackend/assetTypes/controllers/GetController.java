package com.example.etorobackend.assetTypes.controllers;

import com.example.etorobackend.assetTypes.services.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GetController {

    private final AssetTypeService assetTypeService;

    @Autowired
    public GetController(AssetTypeService assetTypeService) {
        this.assetTypeService = assetTypeService;
    }

    @GetMapping("/assets/groups")
    public ResponseEntity<Object> getAll() {
        var assetTypes = this.assetTypeService.get();

        return ResponseEntity.ok().body(assetTypes);
    }
}
