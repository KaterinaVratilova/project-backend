package com.example.etorobackend.assets.entities;

import com.example.etorobackend.assets.enums.AssetGroups;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "asset_groups")
public class AssetGroupEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "asset_group_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "label")
    private AssetGroups label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_type_id")
    private AssetTypeEntity assetType;

    public AssetGroupEntity(AssetGroups label, AssetTypeEntity assetType) {
        this.label = label;
        this.assetType = assetType;
    }
}
