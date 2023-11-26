package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Enrichment(
        @JsonProperty("buy_url")
        String buyUrl,

        @Nullable
        Images images,

        @Nullable
        List<Video> videos
) {
}
