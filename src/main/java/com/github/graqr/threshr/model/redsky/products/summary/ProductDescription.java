package com.github.graqr.threshr.model.redsky.products.summary;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductDescription(String title) {
}
