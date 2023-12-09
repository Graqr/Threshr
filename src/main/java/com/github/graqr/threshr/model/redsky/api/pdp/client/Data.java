package com.github.graqr.threshr.model.redsky.api.pdp.client;

import com.github.graqr.threshr.model.redsky.api.Product;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(Product product) {
}
