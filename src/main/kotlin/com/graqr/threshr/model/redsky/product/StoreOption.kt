package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class StoreOption(
    @param:JsonProperty("search_response_store_type") val searchResponseStoreType: String,
    @param:JsonProperty("location_available_to_promise_quantity") val locationAvailableToPromiseQuantity: Double,
    @param:JsonProperty("location_id") val locationId: String,
    val store: Store,
    @param:JsonProperty("order_pickup") val orderPickup: OrderPickup,
    @param:JsonProperty("in_store_only") val inStoreOnly: InStoreOnly
) {

}
