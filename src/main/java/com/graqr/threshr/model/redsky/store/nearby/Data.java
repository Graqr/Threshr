package com.graqr.threshr.model.redsky.store.nearby;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graqr.threshr.model.redsky.store.NearbyStore;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(@JsonProperty("nearby_stores") NearbyStore nearbyStores) {
}

