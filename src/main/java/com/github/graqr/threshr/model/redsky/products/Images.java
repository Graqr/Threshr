package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.net.URL;
import java.util.List;

@Serdeable
public record Images(
        @JsonProperty("primary_image_url")
        URL primaryImageUrl,
        @JsonProperty("alternate_image_urls")
        URL[] alternateImageUrls,

        @Nullable @JsonProperty("base_url")
        String baseUrl,
        @Nullable @JsonProperty("primary_image")
        String primaryImage,
        @Nullable @JsonProperty("alternate_images")
        List<String> alternateImages,
        @Nullable @JsonProperty("content_labels")
        List<ContentLabel> contentLabels
) {
}
