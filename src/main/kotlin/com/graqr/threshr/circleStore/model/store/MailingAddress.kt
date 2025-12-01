package com.graqr.threshr.circleStore.model.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class MailingAddress(
    @param:JsonProperty("address_line1")
    val addressLine1: String,
    val city: String,
    @param:JsonProperty("country_code")
    val countryCode: String,
    val region: String,
    val state: String,
    @param:JsonProperty("postal_code")
    val postalCode: String,
    @param:Nullable val country: String
) {
}
