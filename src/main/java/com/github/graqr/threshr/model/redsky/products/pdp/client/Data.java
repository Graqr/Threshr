package com.github.graqr.threshr.model.redsky.products.pdp.client;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(Product product) {
}
