package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class VideoCaption(
    @param:JsonProperty("caption_url") val captionUrl: String, val language: String
) {}
