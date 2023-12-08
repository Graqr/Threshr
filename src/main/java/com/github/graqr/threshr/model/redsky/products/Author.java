package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Author(
        String nickname,
        @JsonProperty("external_id")
        String externalId) {
}
