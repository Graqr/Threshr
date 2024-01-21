package com.graqr.threshr.model.redsky.products.pdp.client;

import com.graqr.threshr.model.redsky.products.Product;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(Product product) {
}
