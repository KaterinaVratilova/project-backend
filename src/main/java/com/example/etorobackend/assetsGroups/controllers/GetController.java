package com.example.etorobackend.assetsGroups.controllers;

import com.example.etorobackend.assetsGroups.services.AssetGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GetController {

    private final AssetGroupService assetGroupService;

    @Autowired
    public GetController(AssetGroupService assetGroupService) {
        this.assetGroupService = assetGroupService;
    }

    @GetMapping("/assets/types")
    public ResponseEntity<Object> getAll() {
        var assetGroups = this.assetGroupService.get();

        return ResponseEntity.ok().body(assetGroups);
    }
}
