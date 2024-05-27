package com.graqr.threshr.model.redsky.store;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record DriveUp(Double latitude, Double longitude, Long radius) {}
