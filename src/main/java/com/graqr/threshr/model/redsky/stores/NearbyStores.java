package com.graqr.threshr.model.redsky.stores;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Serdeable
public record NearbyStores(Long count, List<Store> stores) {
}
