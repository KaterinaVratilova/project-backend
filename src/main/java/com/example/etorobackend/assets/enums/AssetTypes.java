package com.example.etorobackend.assets.enums;

public enum AssetTypes {
    STOCKS("STOCKS"),
    CRYPTO("CRYPTO"),
    INDICES("INDICES"),
    ETFS("ETFS"),
    COMMODITIES("COMMODITIES"),
    CURRENCIES("CURRENCIES");

    private final String label;

    private AssetTypes(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
