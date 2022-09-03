package com.example.etorobackend.assets.repositories;

import com.example.etorobackend.assets.entities.AssetTypeEntity;
import com.example.etorobackend.assets.enums.AssetTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssetTypeRepository extends JpaRepository<AssetTypeEntity, UUID> {
    AssetTypeEntity findByType(AssetTypes type);
}
