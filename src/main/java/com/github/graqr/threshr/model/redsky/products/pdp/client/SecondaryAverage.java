package com.github.graqr.threshr.model.redsky.products.pdp.client;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record SecondaryAverage(String id, String label, Long range, String type, Double value) {
}
