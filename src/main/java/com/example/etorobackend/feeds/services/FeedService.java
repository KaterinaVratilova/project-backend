package com.example.etorobackend.feeds.services;

import com.example.etorobackend.feeds.entities.FeedEntity;
import com.example.etorobackend.feeds.model.FeedCreateRequest;
import com.example.etorobackend.feeds.repositories.FeedRepository;
import com.example.etorobackend.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    private final UserService userService;

    @Autowired
    public FeedService(FeedRepository feedRepository, UserService userService) {
        this.feedRepository = feedRepository;
        this.userService = userService;
    }

    public List<FeedEntity> getAll() {
        return this.feedRepository.findAll();
    }

    public FeedEntity create(UUID userId, FeedCreateRequest request) throws Exception {
        var user = this.userService.findById(userId);

        return new FeedEntity(request.story(), user);
    }
}
