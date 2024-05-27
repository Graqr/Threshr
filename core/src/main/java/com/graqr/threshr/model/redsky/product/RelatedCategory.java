package com.graqr.threshr.model.redsky.product;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record RelatedCategory(
        String url,
        String title) {
}
