package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Hold(
    @param:JsonProperty("is_active")
    val isActive: Boolean) {
}
