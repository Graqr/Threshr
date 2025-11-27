package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class AddOn(
    @param:JsonProperty("is_active") val isActive: Boolean
)