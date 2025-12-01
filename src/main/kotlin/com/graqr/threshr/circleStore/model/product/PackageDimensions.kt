package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PackageDimensions(
    val depth: Double,
    val height: Double,
    val weight: Double,
    val width: Double,
    @param:JsonProperty("dimension_unit_of_measure") val dimensionUnitOfMeasure: String,
    @param:JsonProperty("weight_unit_of_measure") val weightUnitOfMeasure: String
) {}
