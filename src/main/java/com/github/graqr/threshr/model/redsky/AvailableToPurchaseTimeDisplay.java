package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record AvailableToPurchaseTimeDisplay(
        @JsonProperty("is_active")
        Boolean isActive
) {
}
