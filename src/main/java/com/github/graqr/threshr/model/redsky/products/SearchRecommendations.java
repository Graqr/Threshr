package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record SearchRecommendations(
        @JsonProperty("category_id")
        String categoryId,
        @JsonProperty("related_categories")
        RelatedCategory[] relatedCategories
) {}
