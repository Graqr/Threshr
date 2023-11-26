package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record ProductDescription(
        String title,

        @Nullable @JsonProperty("bullet_descriptions")
        List<String> bulletDescriptions,

        @Nullable@JsonProperty("soft_bullets")
        SoftBullets softBullets) {
}
