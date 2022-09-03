package com.example.etorobackend.assets.entities;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name = "assets")
public class AssetEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "asset_id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_type_id")
    private AssetTypeEntity assetType;

    public AssetEntity(String name, String shortName, AssetTypeEntity assetType) {
        this.name = name;
        this.shortName = shortName;
        this.assetType = assetType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public AssetTypeEntity getAssetType() {
        return assetType;
    }
}
