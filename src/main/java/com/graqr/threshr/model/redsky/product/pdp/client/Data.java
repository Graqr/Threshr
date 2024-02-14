package com.graqr.threshr.model.redsky.product.pdp.client;

import com.graqr.threshr.model.redsky.product.Product;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(Product product) {
}
