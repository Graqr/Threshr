package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class VideoFile(
    @param:JsonProperty("mime_type") val mimeType: String,
    @param:JsonProperty("video_height_pixels") val videoHeightPixels: String,
    @param:JsonProperty("video_url") val videoUrl: String
) {}
