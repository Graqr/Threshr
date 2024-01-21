package com.graqr.threshr.model.redsky.products;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record SoftBullets(List<String> bullets, String title) {
}
