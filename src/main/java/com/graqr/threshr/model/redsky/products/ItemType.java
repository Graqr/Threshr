package com.graqr.threshr.model.redsky.products;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ItemType(
        String name,
        String type) {
}
