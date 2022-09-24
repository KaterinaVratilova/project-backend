package com.example.etorobackend.assets.repositories;

import com.example.etorobackend.assets.entities.AssetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, UUID> {
    Page<AssetEntity> findByNameContainingIgnoreCase(String label, Pageable pageable);
}
