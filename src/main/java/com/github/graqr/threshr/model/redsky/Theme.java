package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

record Theme(
        String name,
        @JsonProperty("has_swatch")
        Boolean hasSwatch,
        List<Swatch> swatches
) {
}
