package com.github.graqr.threshr.model.redsky.api;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record RelatedCategory(
        String url,
        String title) {
}
