package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Nutrient(
    val name: String,
    val quantity: Double,
    @param:JsonProperty("unit_of_measurement") val unitOfMeasurement: String,
    val percentage: Double
) {}
