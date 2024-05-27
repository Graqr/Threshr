package com.graqr.threshr.model.redsky.product;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record MostRecent(
        String id,
        String text,
        Author author,
        String title,
        Rating rating) {
}
