package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Enrichment(
        @JsonProperty("buy_url")
        String buyUrl,
        Images images,
        @JsonProperty("nutrition_facts")
        NutritionFacts nutritionFacts,
        List<Video> videos,
        @JsonProperty("return_policies")
        List<ReturnPolicy> returnPolicies) {
}
