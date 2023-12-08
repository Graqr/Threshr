package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ScheduledDelivery(
        @JsonProperty("is_active")
        Boolean isActive,
        @Nullable @JsonProperty("location_available_to_promise_quantity")
        Double locationAvailableToPromiseQuantity) {
}
