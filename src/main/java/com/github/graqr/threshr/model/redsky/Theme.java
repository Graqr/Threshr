package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;

import java.util.List;

public record Theme(
        String name,

        @JsonProperty("has_swatch")
        Boolean hasSwatch,

        @Nullable List<Swatch> swatches
) {
}
