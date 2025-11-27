package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class RollingOperatingHours(
    @param:JsonProperty("main_hours")
    val mainHours: MainHours,
    @param:Nullable @param:JsonProperty("capability_hours")
    val capabilityHours: List<CapabilityHour>
) {
}
