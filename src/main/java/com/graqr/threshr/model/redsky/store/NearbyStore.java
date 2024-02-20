package com.graqr.threshr.model.redsky.store;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record NearbyStore(Long count, List<Store> stores) {
}
