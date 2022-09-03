package com.example.etorobackend.assets.entities;

import com.example.etorobackend.assets.enums.AssetTypes;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "asset_types")
public class AssetTypeEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "asset_type_id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", unique = true)
    private AssetTypes type;

    @OneToMany(mappedBy = "id")
    private List<AssetEntity> assets;

    public AssetTypeEntity(AssetTypes type) {
        this.type = type;
    }
}
