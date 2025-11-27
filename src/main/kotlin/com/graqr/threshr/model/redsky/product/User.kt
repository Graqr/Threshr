package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class User(
    @param:JsonProperty("display_name") val displayName: String,
    @param:JsonProperty("image_alt_text") val imageAltText: String,
    @param:JsonProperty("image_url") val imageUrl: String,
    val url: String,
    val username: String
) {}

