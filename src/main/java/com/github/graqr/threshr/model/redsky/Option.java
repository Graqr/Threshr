package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record Option(
        @JsonProperty("display_name")
        String displayName,

        String id,
        String url,
        String value
) {
}
