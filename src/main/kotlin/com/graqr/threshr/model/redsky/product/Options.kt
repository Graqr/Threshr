package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Options(
    @param:JsonProperty("display_name") val displayName: String,
    @param:JsonProperty("canonical_name") val canonicalName: String,
    val id: String,
    @param:Nullable val source: String,
    @param:JsonProperty("image_url") @param:Nullable val imageUrl: String,
    val url: String,
    val value: String
) {}
