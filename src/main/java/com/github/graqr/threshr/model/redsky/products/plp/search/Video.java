package com.github.graqr.threshr.model.redsky.products.plp.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.graqr.threshr.model.redsky.products.pdp.client.VideoCaption;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.annotation.Nullable;

import java.util.List;

@Serdeable
public record Video(
        @JsonProperty("video_files") List<VideoFile> videoFiles,

        @Nullable @JsonProperty("video_captions") List<VideoCaption> videoCaptions,
        @Nullable @JsonProperty("video_length_seconds") String videoLengthSeconds,
        @Nullable @JsonProperty("video_poster_image") String videoPosterImage,
        @Nullable @JsonProperty("video_title") String videoTitle,
        @Nullable Boolean isListPageEligible) {
}
