package com.graqr.threshr.model.redsky.stores;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(@JsonProperty("nearby_stores") NearbyStores nearbyStores) {
}

