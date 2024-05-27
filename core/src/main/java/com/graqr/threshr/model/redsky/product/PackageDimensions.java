package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record PackageDimensions(
        Double depth, Double height, Double weight, Double width,
        @JsonProperty("dimension_unit_of_measure")
        String dimensionUnitOfMeasure,
        @JsonProperty("weight_unit_of_measure")
        String weightUnitOfMeasure) {
}
