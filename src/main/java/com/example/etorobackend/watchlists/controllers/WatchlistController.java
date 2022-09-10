package com.example.etorobackend.watchlists.controllers;

import com.example.etorobackend.watchlists.model.WatchlistCreateRequest;
import com.example.etorobackend.watchlists.services.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WatchlistController {

    private final WatchlistService watchlistService;

    @Autowired
    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @GetMapping("/user/{userId}/watchlist")
    public ResponseEntity<Object> getAll() {
        var watchlists = this.watchlistService.getAll();

        return ResponseEntity.ok().body(watchlists);
    }

    @PostMapping("/user/{userId}/watchlist")
    public ResponseEntity<Object> create(
        @PathVariable("userId") UUID id,
        @RequestBody @Valid WatchlistCreateRequest request
    ) throws Exception {
        this.watchlistService.create(id, request);

        return ResponseEntity.created(null).build();
    }
}
