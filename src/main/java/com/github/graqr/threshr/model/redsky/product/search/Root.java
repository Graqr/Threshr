package com.github.graqr.threshr.model.redsky.product.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Root(
        @JsonProperty("data")
        Data data) {
}
