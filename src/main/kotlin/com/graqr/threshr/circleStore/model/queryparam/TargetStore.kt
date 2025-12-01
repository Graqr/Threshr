package com.graqr.threshr.circleStore.model.queryparam

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.annotation.QueryValue

/**
 * TargetStore object used with micronaut's deserialization for querying the RedSky API
 */
@Introspected
data class TargetStore(
    @param:QueryValue("store_id") val storeId: String,
    @param:QueryValue("scheduled_delivery_store_id") val scheduledDeliveryStoreId: String,
    @param:QueryValue("required_store_id") val requiredStoreId: String,
    val zip: String, val state: String, val latitude: Double, val longitude: Double) {

    /**
     * instantiates a TargetStore where the locationID string is used for store_id, scheduled_delivery_store_id,
     * and required_store_id
     */
    constructor(locationId: String, region: String, postalCode: String, latitude: Double, longitude: Double) :
            this(locationId, locationId, locationId, postalCode, region, latitude, longitude) {}
}
