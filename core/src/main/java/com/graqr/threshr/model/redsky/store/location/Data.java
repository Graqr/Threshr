package com.graqr.threshr.model.redsky.store.location;

import com.graqr.threshr.model.redsky.store.Store;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Data(Store store) {
}
