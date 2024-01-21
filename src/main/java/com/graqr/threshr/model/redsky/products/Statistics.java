package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Statistics(
        @JsonProperty("not_recommended_count") Long notRecommendedCount,
        @JsonProperty("question_count") Long questionCount, Rating rating,
        @JsonProperty("recommended_count") Long recommendedCount,
        @JsonProperty("recommended_percentage") Long recommendedPercentage,
        @JsonProperty("review_count") Long reviewCount) {
}
