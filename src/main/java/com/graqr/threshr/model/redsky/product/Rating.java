package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Rating(
        @Nullable Double average,
        @Nullable Long count,
        @Nullable Distribution distribution,
        @JsonProperty("secondary_averages")
        @Nullable List<SecondaryAverage> secondaryAverages,
        @Nullable Double value,
        @JsonProperty("submitted_at")
        String submittedAt) {
}
