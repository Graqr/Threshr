package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.graqr.threshr.model.redsky.products.plp.search.Images;
import com.github.graqr.threshr.model.redsky.products.plp.search.Video;
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
