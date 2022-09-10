package com.example.etorobackend.watchlists.services;

import com.example.etorobackend.users.services.UserGetService;
import com.example.etorobackend.watchlists.entities.WatchlistEntity;
import com.example.etorobackend.watchlists.model.WatchlistCreateRequest;
import com.example.etorobackend.watchlists.model.WatchlistResponse;
import com.example.etorobackend.watchlists.repositories.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WatchlistService {

    private final WatchlistRepository watchlistRepository;

    private final UserGetService userGetService;

    @Autowired
    public WatchlistService(
            WatchlistRepository watchlistRepository,
            UserGetService userGetService
    ) {
        this.watchlistRepository = watchlistRepository;
        this.userGetService = userGetService;
    }

    public List<WatchlistResponse> getAll() {
        return this.watchlistRepository.findAll().stream().map(watchlistEntity -> {
            return new WatchlistResponse(watchlistEntity.getId(), watchlistEntity.getLabel());
        }).toList();
    }

    public void create(UUID userId, WatchlistCreateRequest request) throws Exception {
        var user = this.userGetService.findById(userId);

        var watchlist = new WatchlistEntity(request.label(), user);

        this.watchlistRepository.save(watchlist);
    }

}
