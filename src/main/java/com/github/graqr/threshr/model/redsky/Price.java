package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Price(
        @JsonProperty("formatted_comparison_price")
        String formattedComparisonPrice,

        @JsonProperty("formatted_comparison_price_type")
        String formattedComparisonPriceType,

        @JsonProperty("formatted_current_price")
        String formattedCurrentPrice,

        @JsonProperty("formatted_current_price_type")
        String formattedCurrentPriceType,

        @Nullable @JsonProperty("reg_retail") //for some reason this isn't always provided in target's response
        Double price,

        @JsonProperty("location_id")
        Long locationId,

        @Nullable String urgency) {

}
