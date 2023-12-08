package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Nutrient(String name,
                       Double quantity,
                       @JsonProperty("unit_of_measurement")
                       String unitOfMeasurement,
                       Double percentage) {
}
