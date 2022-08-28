package com.example.etorobackend.assets.services;

import com.example.etorobackend.assets.model.AssetResponse;
import com.example.etorobackend.assets.repositories.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetResponse> getAll() {
        return assetRepository.findAll().stream().map(asset -> {
            return new AssetResponse(asset.getId(), asset.getName(), asset.getShortName());
        }).toList();
    }

    /*
     * Asi bych vratil AssetResponse
     * Vyuzijte AssetNotFoundException
     *  metoda bude vrace optional, doporucuju se prvne podivat jestli to neco naslo, kdyz ne tak vyhodit exception
     *  potom se da zavolat na optional .get a pak uz se s tim da normalne pracovat
     */
}
