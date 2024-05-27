package com.graqr.threshr.model.redsky.store.nearby;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public record NearbyStoreRoot(Data data) {
}

