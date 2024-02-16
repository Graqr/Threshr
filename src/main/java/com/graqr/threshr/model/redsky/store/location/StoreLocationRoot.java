package com.graqr.threshr.model.redsky.store.location;

import com.graqr.threshr.model.redsky.store.nearby.Data;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record StoreLocationRoot(Data data) {}
