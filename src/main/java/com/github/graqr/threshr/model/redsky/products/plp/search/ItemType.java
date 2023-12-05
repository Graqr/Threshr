package com.github.graqr.threshr.model.redsky.products.plp.search;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ItemType(
        String name,
        String type) {
}
