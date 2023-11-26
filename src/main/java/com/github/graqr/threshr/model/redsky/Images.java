package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

record Images(
        @JsonProperty("primary_image_url")
        String primaryImageUrl,
        @JsonProperty("alternate_image_urls")
        List<String> alternateImageUrls
) {
}
