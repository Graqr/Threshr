package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.annotation.Nullable;

@Serdeable
public record Price(
        @JsonProperty("formatted_current_price") String formattedCurrentPrice,
        @JsonProperty("formatted_current_price_type") String formattedCurrentPriceType,
        @JsonProperty("reg_retail") Double regRetail,
        @JsonProperty("formatted_unit_price") String formattedUnitPrice,
        @JsonProperty("formatted_unit_price_suffix") String formattedUnitPriceSuffix,
        @JsonProperty("location_id") Long locationId,
        @Nullable @JsonProperty("current_retail") Double currentRetail,
        @Nullable @JsonProperty("external_system_id") String externalSystemId,
        @Nullable @JsonProperty("is_current_price_range") Boolean isCurrentPriceRange) {
}
