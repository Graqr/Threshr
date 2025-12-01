package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

/**
 * This class is kept separate from ...circle.store.Store as this object only has a location name
 * @param locationName
 */
@Serdeable
data class Store(@param:JsonProperty("location_name") val locationName: String) {}
