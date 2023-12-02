package com.github.graqr.threshr.model.redsky.product.summary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.graqr.threshr.model.redsky.product.search.Data;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Root(
        @JsonProperty("data")
        Data data) {
}
