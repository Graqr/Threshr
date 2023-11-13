package com.github.peanutbutter.unicorn.tarvester.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record OrderPickup(
        @JsonProperty("availability_status")
        String availabilityStatus,
        @JsonProperty("pickup_date")
        String pickupDate,
        @JsonProperty("guest_pick_sla")
        Long guestPickSla,
        @JsonProperty("location_locale")
        String locationLocale) {
}
