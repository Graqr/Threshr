package com.github.graqr.threshr.model.redsky.products;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record RelatedCategory(
        String url,
        String title) {
}
