package com.graqr.threshr.model.redsky.products.summary;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductSummaryRoot(Data data) {
}
