package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record AvailableToPurchaseDateDisplay(
        @JsonProperty("is_active")
        Boolean isActive
) {
}
