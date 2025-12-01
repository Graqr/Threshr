package com.graqr.threshr.circleStore.model.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class GeographicSpecifications(
    val latitude: Double,
    val longitude: Double,
    @param:JsonProperty("time_zone_code") val timeZoneCode: String,
    @param:JsonProperty("time_zone_description") val timeZoneDescription: String,
    @param:JsonProperty("time_zone_utc_offset_name") val timeZoneUtcOffsetName: String,
    @param:JsonProperty("time_zone_offset_hours") val timeZoneOffsetHours: String,
    @param:JsonProperty("is_daylight_savings_time_recognized") val isDaylightSavingsTimeRecognized: Boolean,
    @param:JsonProperty("iso_time_zone_code") val isoTimeZoneCode: String
) {
}
