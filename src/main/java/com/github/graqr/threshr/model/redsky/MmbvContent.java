package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MmbvContent(
        @JsonProperty("street_date")
        String streetDate
) {
}
