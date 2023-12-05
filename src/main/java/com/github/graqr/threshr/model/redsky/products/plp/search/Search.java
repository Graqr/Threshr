package com.github.graqr.threshr.model.redsky.products.plp.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Search(
        @JsonProperty("search_recommendations")
        SearchRecommendations searchRecommendations,
        @JsonProperty("search_response")
        SearchResponse searchResponse
) {
}
