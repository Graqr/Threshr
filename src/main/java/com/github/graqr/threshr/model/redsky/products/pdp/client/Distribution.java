package com.github.graqr.threshr.model.redsky.products.pdp.client;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Distribution(
        Long rating1,
        Long rating2,
        Long rating3,
        Long rating4,
        Long rating5) {
}
