package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable

@Serdeable
data class Video(
    @param:JsonProperty("video_files") val videoFiles: List<VideoFile>,
    @param:Nullable @param:JsonProperty("video_captions") val videoCaptions: List<VideoCaption>,
    @param:Nullable @param:JsonProperty("video_length_seconds") val videoLengthSeconds: String,
    @param:Nullable @param:JsonProperty("video_poster_image") val videoPosterImage: String,
    @param:Nullable @param:JsonProperty("video_title") val videoTitle: String,
    @param:Nullable val isListPageEligible: Boolean
) {}
