package com.graqr.threshr.circleStore.model.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Hour(
    @param:Nullable @param:JsonProperty("begin_date")
    val beginDate: String,
    @param:JsonProperty("begin_time") val beginTime: String,
    @param:JsonProperty("end_date") val endDate: String,
    @param:JsonProperty("end_time") val endTime: String
) {
}
