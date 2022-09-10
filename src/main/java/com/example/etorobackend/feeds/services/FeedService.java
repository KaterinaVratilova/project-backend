package com.example.etorobackend.feeds.services;

import com.example.etorobackend.feeds.entities.FeedEntity;
import com.example.etorobackend.feeds.model.FeedCreateRequest;
import com.example.etorobackend.feeds.repositories.FeedRepository;
import com.example.etorobackend.users.services.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    private final UserGetService userGetService;

    @Autowired
    public FeedService(FeedRepository feedRepository, UserGetService userGetService) {
        this.feedRepository = feedRepository;
        this.userGetService = userGetService;
    }

    public List<FeedEntity> getAll() {
        return this.feedRepository.findAll();
    }

    public FeedEntity create(UUID userId, FeedCreateRequest request) throws Exception {
        var user = this.userGetService.findById(userId);

        return new FeedEntity(request.story(), user);
    }
}
