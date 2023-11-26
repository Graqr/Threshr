package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.context.annotation.Any;
import io.micronaut.core.annotation.Nullable;

import java.util.List;
import java.util.Map;

record Search(
        @JsonProperty("search_recommendations")
        SearchRecommendations searchRecommendations,
        @JsonProperty("search_response")
        SearchResponse searchResponse,
        List<Product> products  
        ){}

