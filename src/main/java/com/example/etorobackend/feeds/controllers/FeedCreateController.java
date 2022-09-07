package com.example.etorobackend.feeds.controllers;

import com.example.etorobackend.feeds.model.FeedCreateRequest;
import com.example.etorobackend.feeds.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class FeedCreateController {

    private final FeedService feedService;

    @Autowired
    public FeedCreateController(FeedService feedService) {
        this.feedService = feedService;
    }

    @PostMapping("/user/{userId}/feed")
    public ResponseEntity<Object> create(
            @PathVariable("userId") UUID id,
            @RequestBody @Valid FeedCreateRequest request
    ) throws Exception {
        this.feedService.create(id, request);

        return ResponseEntity.created(null).build();
    }
}
