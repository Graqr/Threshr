package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record VideoFile(
        @JsonProperty("mime_type")
        String mimeType,

        @JsonProperty("video_url")
        String videoUrl
) {
}
