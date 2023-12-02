package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Option(
        @JsonProperty("display_name")
        String displayName,

        String id,
        String url,
        String value
) {
}
