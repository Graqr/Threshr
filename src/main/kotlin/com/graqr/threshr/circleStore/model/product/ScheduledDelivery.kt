package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ScheduledDelivery(
    @param:JsonProperty("is_active") val isActive: Boolean,
    @param:Nullable @param:JsonProperty("location_available_to_promise_quantity") val locationAvailableToPromiseQuantity: Double
) {}
