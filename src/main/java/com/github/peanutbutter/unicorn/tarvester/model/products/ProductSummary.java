package com.github.peanutbutter.unicorn.tarvester.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductSummary(
        @JsonProperty("__typename")
        String typename,
        String tcin,
        Item item,
        @Nullable
        Fulfillment fulfillment) {
}
