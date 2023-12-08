package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Image(
        String url,
        @JsonProperty("alt_text")
        String altText,
        Long height,
        Long width,
        @JsonProperty("aspect_ratio")
        String aspectRatio) {
}