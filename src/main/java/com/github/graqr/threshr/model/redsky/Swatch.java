package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Swatch(
        String value,

        @JsonProperty("first_child")
        FirstChild firstChild
) {
}
