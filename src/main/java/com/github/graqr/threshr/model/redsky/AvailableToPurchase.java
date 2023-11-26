package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record AvailableToPurchase(
        @JsonProperty("start_date_time")
        String startDateTime
) {
}
