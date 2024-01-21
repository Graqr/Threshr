package com.graqr.threshr.model.redsky.products;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record SecondaryAverage(String id, String label, Long range, String type, Double value) {
}
