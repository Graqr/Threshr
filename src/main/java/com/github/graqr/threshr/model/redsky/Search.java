package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

record Search(
        @JsonProperty("search_recommendations")
        SearchRecommendations searchRecommendations,

        @JsonProperty("search_response")
        SearchResponse searchResponse,

        List<Product> products
        ){}

