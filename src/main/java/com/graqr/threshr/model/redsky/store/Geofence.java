package com.graqr.threshr.model.redsky.store;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Geofence(Double latitude, Double longitude, Long radius) {}
