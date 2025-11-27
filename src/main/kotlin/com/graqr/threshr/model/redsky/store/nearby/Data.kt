package com.graqr.threshr.model.redsky.store.nearby

import com.fasterxml.jackson.annotation.JsonProperty
import com.graqr.threshr.model.redsky.store.NearbyStores
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Data(@param:JsonProperty("nearby_stores") val nearbyStores: NearbyStores) {
}

