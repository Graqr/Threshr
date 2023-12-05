package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ReturnPolicy(@JsonProperty("user_type") String userType, @JsonProperty("day_count") Long dayCount) {
}
