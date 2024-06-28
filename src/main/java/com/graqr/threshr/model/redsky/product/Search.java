package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Search(
        @JsonProperty("search_recommendations")
        SearchRecommendations searchRecommendations,
        @JsonProperty("search_response")
        SearchResponse searchResponse,
        @Nullable
        @JsonProperty("search_suggestions")
        String[] searchSuggestions,
        @Nullable
        Product[] products
) {
}
