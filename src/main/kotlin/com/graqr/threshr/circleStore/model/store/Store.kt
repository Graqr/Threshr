package com.graqr.threshr.circleStore.model.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@Introspected
data class Store(
    val status: String,
    @param:JsonProperty("store_id") val storeId: String,
    @param:JsonProperty("location_name") val locationName: String,
    val distance: Double,
    @param:JsonProperty("main_voice_phone_number") val mainVoicePhoneNumber: String,
    @param:JsonProperty("mailing_address") val mailingAddress: MailingAddress,
    @param:JsonProperty("rolling_operating_hours") val rollingOperatingHours: RollingOperatingHours,
    @param:Nullable val geofence: Geofence,
    @param:Nullable val capabilities: List<Capability>,
    @param:Nullable @param:JsonProperty("drive_up") val driveUp: DriveUp,
    @param:Nullable @param:JsonProperty("contact_information") val contactInformation: List<ContactInformation>,
    @param:Nullable @param:JsonProperty("physical_specifications") val physicalSpecifications: PhysicalSpecifications,
    @param:Nullable @param:JsonProperty("geographic_specifications") val geographicSpecifications: GeographicSpecifications,
    @param:Nullable val miscellaneous: Miscellaneous
) {}
