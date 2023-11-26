package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record value(
        String label,
        String url,
        @JsonProperty("category_id")
        String categoryId
) {
}
