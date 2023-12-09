package com.github.graqr.threshr.model.redsky.api;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record SoftBullets(List<String> bullets, String title) {
}
