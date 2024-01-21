package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record FindsStory(
        String id, @JsonProperty("channel_id") String channelId, String description,
        @JsonProperty("display_date") String displayDate,
        @JsonProperty("highlight_color") String highlightColor, Image image, List<Image> images,
        String label, String name, @JsonProperty("short_title") String shortTitle, String title,
        String url) {
}
