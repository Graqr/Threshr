package com.graqr.threshr.circleStore.model.store

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class NearbyStores(val count: Long, val stores: List<Store>) {}
