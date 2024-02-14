package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ReturnPolicy(@JsonProperty("user_type") String userType, @JsonProperty("day_count") Long dayCount) {
}
