package com.example.etorobackend.assetsGroups.services;

import com.example.etorobackend.assets.entities.AssetGroupEntity;
import com.example.etorobackend.assets.repositories.AssetTypeRepository;
import com.example.etorobackend.assetsGroups.repositories.AssetGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetGroupService {

    private final AssetGroupRepository assetGroupRepository;

    @Autowired
    public AssetGroupService(AssetGroupRepository assetGroupRepository) {
        this.assetGroupRepository = assetGroupRepository;
    }

    public List<AssetGroupEntity> get() {
        return this.assetGroupRepository.findAll();
    }
}
