package com.example.etorobackend.watchlists.repositories;

import com.example.etorobackend.watchlists.entities.WatchlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WatchlistRepository extends JpaRepository<WatchlistEntity, UUID> {
}
