package com.example.etorobackend.assets.controllers;

import com.example.etorobackend.assets.enums.SortEnum;
import com.example.etorobackend.assets.exceptions.AssetNotFoundException;
import com.example.etorobackend.assets.services.AssetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    // 1, 2, 3
    // Stranka 2
    // Pocet zaznamu 10
    // 0 - 10
    // 11 - 20
    // 21 - 30
    // page * pocet zaznamu
    // (page - 1) * pocet_zaznamu, page * pocet_zaznamu
    // 0, 10
    // 10, 20

    @GetMapping("/assets")
    public ResponseEntity<Object> getAll(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @RequestParam("search") Optional<String> search,
            @RequestParam("sort") Optional<SortEnum> sort
    ) {
        var assets = assetService.getAll(
                page.orElse(0),
                size.orElse(10),
                sort.orElse(SortEnum.ASC),
                search.orElse("")
        );

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
