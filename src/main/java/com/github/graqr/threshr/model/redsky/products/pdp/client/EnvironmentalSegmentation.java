package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record EnvironmentalSegmentation(
        @JsonProperty("is_hazardous_material")
        Boolean isHazardousMaterial) {
}
