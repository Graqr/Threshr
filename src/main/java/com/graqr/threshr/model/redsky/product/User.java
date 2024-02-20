package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record User(
        @JsonProperty("display_name") String displayName,
        @JsonProperty("image_alt_text") String imageAltText,
        @JsonProperty("image_url") String imageUrl,
        String url, String username) {
}

