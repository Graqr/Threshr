package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Parent(
        @JsonProperty("__typename")
        String typename,

        String tcin,
        Item item,
        List<Promotion> promotions,
        Price price,

        @JsonProperty("ratings_and_reviews")
        RatingsAndReviews ratingsAndReviews,

        @JsonProperty("variation_summary")
        VariationSummary variationSummary
) {
}
