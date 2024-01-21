package com.graqr.threshr.model.redsky.products;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Distribution(
        Long rating1,
        Long rating2,
        Long rating3,
        Long rating4,
        Long rating5) {
}
