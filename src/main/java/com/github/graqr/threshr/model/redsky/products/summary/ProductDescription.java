package com.github.graqr.threshr.model.redsky.products.summary;

import com.github.graqr.threshr.model.redsky.products.plp.search.SoftBullet;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductDescription(
        String title,
        String[] bulletDescriptions,
        SoftBullet[] softBullets
) {
}
