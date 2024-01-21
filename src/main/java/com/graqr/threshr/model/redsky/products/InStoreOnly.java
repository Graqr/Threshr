package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record InStoreOnly(
        @JsonProperty("availability_status")
        String availabilityStatus) {
}
