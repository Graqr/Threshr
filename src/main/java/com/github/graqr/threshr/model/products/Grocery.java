package com.github.graqr.threshr.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Grocery(@JsonProperty("is_active") Boolean isActive) {

}
