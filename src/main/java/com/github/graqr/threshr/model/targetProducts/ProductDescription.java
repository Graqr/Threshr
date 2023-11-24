package com.github.graqr.threshr.model.targetProducts;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductDescription(String title) {
}
