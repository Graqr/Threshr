package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record Value(
        String label,

        String url,

        @JsonProperty("category_id")
        String categoryId
) {
}
