package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class EnvironmentalSegmentation(
    @param:JsonProperty("is_hazardous_material") val isHazardousMaterial: Boolean
) {}
