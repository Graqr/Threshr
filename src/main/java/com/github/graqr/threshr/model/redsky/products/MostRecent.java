package com.github.graqr.threshr.model.redsky.products;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record MostRecent(
        String id,
        String text,
        Author author,
        String title,
        Rating rating) {
}
