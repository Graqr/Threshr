package com.graqr.threshr.circleStore.model.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class CapabilityHour(@param:JsonProperty("capability_code") val capabilityCode: String, val days: List<Day>) {}
