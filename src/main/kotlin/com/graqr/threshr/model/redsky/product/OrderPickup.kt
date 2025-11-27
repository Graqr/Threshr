package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class OrderPickup(
    @param:JsonProperty("availability_status") val availabilityStatus: String,
    @param:Nullable @param:JsonProperty("pickup_date") val pickupDate: String,
    @param:Nullable @param:JsonProperty("guest_pick_sla") val guestPickSla: Long,
    @param:Nullable @param:JsonProperty("location_locale") val locationLocale: String
) {}
