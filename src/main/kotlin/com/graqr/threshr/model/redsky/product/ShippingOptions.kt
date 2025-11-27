package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ShippingOptions(
    @param:JsonProperty("availability_status") val availabilityStatus: String,
    @param:JsonProperty("loyalty_availability_status") val loyaltyAvailabilityStatus: String,
    val services: List<Any>
) {}
