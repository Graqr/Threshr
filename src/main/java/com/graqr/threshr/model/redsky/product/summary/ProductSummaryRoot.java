package com.graqr.threshr.model.redsky.product.summary;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductSummaryRoot(Data data) {
}
