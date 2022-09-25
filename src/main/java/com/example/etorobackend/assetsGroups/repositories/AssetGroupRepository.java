package com.example.etorobackend.assetsGroups.repositories;

import com.example.etorobackend.assets.entities.AssetGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssetGroupRepository extends JpaRepository<AssetGroupEntity, UUID> {
}
