package com.github.graqr.threshr.model.redsky.api;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ItemType(
        String name,
        String type) {
}
