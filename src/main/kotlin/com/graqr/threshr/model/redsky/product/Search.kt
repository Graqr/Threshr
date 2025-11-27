package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Search(
    @param:JsonProperty("search_recommendations") val searchRecommendations: SearchRecommendations,
    @param:JsonProperty("search_response") val searchResponse: SearchResponse,
    @param:Nullable @param:JsonProperty("search_suggestions") val searchSuggestions: List<String>,
    @param:Nullable val products: List<Product>
) {}
