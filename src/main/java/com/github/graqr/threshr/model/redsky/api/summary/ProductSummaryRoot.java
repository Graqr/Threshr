package com.github.graqr.threshr.model.redsky.api.summary;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductSummaryRoot(Data data) {
}
