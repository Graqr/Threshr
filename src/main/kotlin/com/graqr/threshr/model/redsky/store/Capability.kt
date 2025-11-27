package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Capability(
    @param:JsonProperty("capability_code") val capabilityCode: String,
    @param:JsonProperty("capability_name") val capabilityName: String,
    @param:JsonProperty("effective_date") val effectiveDate: String
) {}
