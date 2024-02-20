package com.graqr.threshr.model.redsky.product;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record SoftBullet(
        List<String> bullets
) {
}
