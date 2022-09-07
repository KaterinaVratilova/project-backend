package com.example.etorobackend.feeds.controllers;

import com.example.etorobackend.feeds.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class FeedGetController {

    private final FeedService feedService;

    @Autowired
    public FeedGetController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/feeds")
    public ResponseEntity<Object> getAll() {
        var feeds = feedService.getAll();

        return ResponseEntity.ok().body(feeds);
    }
}
