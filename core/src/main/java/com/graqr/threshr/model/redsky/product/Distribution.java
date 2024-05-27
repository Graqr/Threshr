package com.graqr.threshr.model.redsky.product;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Distribution(
        Long rating1,
        Long rating2,
        Long rating3,
        Long rating4,
        Long rating5) {
}
