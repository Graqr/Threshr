package com.github.graqr.threshr.model.products;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductVendor(String id) {
}