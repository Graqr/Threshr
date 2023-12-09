package com.github.graqr.threshr.model.redsky.api.plp.search;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record plpSearchRoot(Data data) {
}
