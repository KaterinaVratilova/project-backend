package com.example.etorobackend.assets.enums;

public enum AssetGroups {
    INDICES_DEFAULT("INDICES_DEFAULT"),
    ETF_DEFAULT("ETF_DEFAULT"),
    CURRENCIES_DEFAULT("CURRENCIES_DEFAULT"),
    COMMODITIES_DEFAULT("COMMODITIES_DEFAULT"),

    COINS("COINS"),
    CRYPTO_CROSSES("CRYPTO_CROSSES"),
    CURRENCY_CROSSES("CURRENCY_CROSSES"),
    COMMODITY_CROSSES("COMMODITY_CROSSES"),

    TECH("TECH"),
    DURABLE_GOODS("DURABLE_GOODS"),
    TRANSPORTATION("TRANSPORTATION"),
    RETAIL("RETAIL"),
    SOFTWARE("SOFTWARE"),
    FINANCIAL_SERVICES("FINANCIAL_SERVICES"),
    CONSUMABLE_GOODS("CONSUMABLE_GOODS"),
    MANUFACTURING("MANUFACTURING"),
    MED_TECH("MED_TECH"),
    ENTERTAINMENT("ENTERTAINMENT"),
    ENERGY("ENERGY");

    private final String label;

    private AssetGroups(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
