package com.graqr.threshr.model.redsky.product;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Disclaimer(
        String description,
        String type) {
}
