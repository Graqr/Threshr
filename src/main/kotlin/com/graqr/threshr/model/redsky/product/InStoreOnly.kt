package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class InStoreOnly(
    @param:JsonProperty("availability_status") val availabilityStatus: String
) {}
