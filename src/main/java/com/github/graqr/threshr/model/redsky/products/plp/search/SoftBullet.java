package com.github.graqr.threshr.model.redsky.products.plp.search;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record SoftBullet(
        List<String> bullets
) {
}
