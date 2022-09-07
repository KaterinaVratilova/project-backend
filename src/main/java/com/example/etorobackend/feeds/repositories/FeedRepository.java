package com.example.etorobackend.feeds.repositories;

import com.example.etorobackend.feeds.entities.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, UUID> {
}
