package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record ValuePreparedList(
        String description,
        @JsonProperty("serving_size") String servingSize,
        @JsonProperty("serving_size_unit_of_measurement") String servingSizeUnitOfMeasurement,
        @JsonProperty("servings_per_container") String servingsPerContainer,
        List<Nutrient> nutrients) {
}
