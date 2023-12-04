package com.github.graqr.threshr.model.redsky.products.summary;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Store(@JsonProperty("location_name")
                    String locationName) {
}
