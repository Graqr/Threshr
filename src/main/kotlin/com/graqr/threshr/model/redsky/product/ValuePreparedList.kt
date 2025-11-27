package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ValuePreparedList(
    val description: String,
    @param:JsonProperty("serving_size") val servingSize: String,
    @param:JsonProperty("serving_size_unit_of_measurement") val servingSizeUnitOfMeasurement: String,
    @param:JsonProperty("servings_per_container") val servingsPerContainer: String,
    val nutrients: List<Nutrient>
) {}
