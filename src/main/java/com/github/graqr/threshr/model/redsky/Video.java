package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

record Video(
        @JsonProperty("is_list_page_eligible")
        Boolean isListPageEligible,

        @JsonProperty("video_files")
        List<VideoFile> videoFiles
) {
}
