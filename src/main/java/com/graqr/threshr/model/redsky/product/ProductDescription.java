package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record ProductDescription(
        @JsonProperty("bullet_descriptions") List<String> bulletDescriptions,
        @JsonProperty("downstream_description") String downstreamDescription,
        @JsonProperty("soft_bullet_description") String softBulletDescription,
        @JsonProperty("soft_bullets") SoftBullets softBullets, String title) {
}
