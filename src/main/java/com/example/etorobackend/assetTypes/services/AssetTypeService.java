package com.example.etorobackend.assetTypes.services;

import com.example.etorobackend.assets.entities.AssetTypeEntity;
import com.example.etorobackend.assets.repositories.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetTypeService {

    private final AssetTypeRepository assetTypeRepository;

    @Autowired
    public AssetTypeService(AssetTypeRepository assetTypeRepository) {
        this.assetTypeRepository = assetTypeRepository;
    }

    public List<AssetTypeEntity> get() {
        return this.assetTypeRepository.findAll();
    }
}
