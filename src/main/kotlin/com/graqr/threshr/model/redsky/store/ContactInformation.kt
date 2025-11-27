package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ContactInformation(
    @param:JsonProperty("building_area") val buildingArea: String,
    @param:JsonProperty("telephone_type") val telephoneType: String,
    @param:JsonProperty("is_international_phone_number") val isInternationalPhoneNumber: Boolean,
    @param:JsonProperty("telephone_number") val telephoneNumber: String,
    val capability: String
) {}
