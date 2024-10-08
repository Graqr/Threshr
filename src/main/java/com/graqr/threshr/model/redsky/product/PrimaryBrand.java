package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record PrimaryBrand(
        @JsonProperty("canonical_url") String canonicalUrl,
        @JsonProperty("linking_id") String linkingId,
        String name) {
}
