package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Image(
    val url: String,
    @param:JsonProperty("alt_text") val altText: String,
    val height: Long,
    val width: Long,
    @param:JsonProperty("aspect_ratio") val aspectRatio: String
) {}