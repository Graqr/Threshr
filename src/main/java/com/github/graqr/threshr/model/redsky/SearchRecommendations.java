package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record SearchRecommendations(
        @JsonProperty("category_id")
        String categoryId
) {
}
