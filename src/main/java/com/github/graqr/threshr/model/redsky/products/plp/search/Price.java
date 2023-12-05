package com.github.graqr.threshr.model.redsky.products.plp.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Price(
        @JsonProperty("formatted_current_price")
        String formattedCurrentPrice,
        @JsonProperty("formatted_current_price_type")
        String formattedCurrentPriceType,
        @JsonProperty("reg_retail")
        String regRetail,
        @JsonProperty("formatted_unit_price")
        String formattedUnitPrice,
        @JsonProperty("formatted_unit_price_suffix")
        String formattedUnitPriceSuffix,
        @JsonProperty("locationId")
        String locationId
) {
}
