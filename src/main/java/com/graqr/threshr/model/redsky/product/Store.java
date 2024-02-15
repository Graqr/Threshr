package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

/**
 * This class is kept separate from ...redsky.store.Store as this object only has a location name
 * @param locationName
 */
@Serdeable
public record Store(@JsonProperty("location_name")
                    String locationName) {
}
