package com.github.graqr.threshr.model.redsky.products.summary;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ScheduledDelivery(
        @JsonProperty("availability_status")
        String availabilityStatus,
        @JsonProperty("location_available_to_promise_quantity")
        Double locationAvailableToPromiseQuantity) {
}
