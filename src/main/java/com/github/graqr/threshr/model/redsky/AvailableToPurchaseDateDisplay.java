package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AvailableToPurchaseDateDisplay(
        @JsonProperty("is_active")
        Boolean isActive
) {
}
