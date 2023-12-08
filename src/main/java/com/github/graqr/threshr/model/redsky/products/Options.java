package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Options(
        @JsonProperty("display_name")
        String displayName,
        @JsonProperty("canonical_name")
        String canonicalName,
        String id,
        @Nullable String source,
        @JsonProperty("image_url")
        @Nullable String imageUrl,
        String url,
        String value
) {
}
