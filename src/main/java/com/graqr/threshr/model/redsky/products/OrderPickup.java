package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record OrderPickup(
        @JsonProperty("availability_status")
        String availabilityStatus,
        @Nullable
        @JsonProperty("pickup_date")
        String pickupDate,
        @Nullable
        @JsonProperty("guest_pick_sla")
        Long guestPickSla,
        @Nullable
        @JsonProperty("location_locale")
        String locationLocale) {
}
