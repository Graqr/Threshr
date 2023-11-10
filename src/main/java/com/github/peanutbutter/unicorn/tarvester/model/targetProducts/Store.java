package com.github.peanutbutter.unicorn.tarvester.model.targetProducts;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Store(@JsonProperty("location_name")
                    String locationName) {
}
