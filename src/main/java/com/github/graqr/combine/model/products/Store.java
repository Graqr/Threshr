package com.github.graqr.combine.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Store(@JsonProperty("location_name")
                    String locationName) {
}
