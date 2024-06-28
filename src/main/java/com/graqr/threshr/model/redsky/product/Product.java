package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Product(
        @JsonProperty("__typename") String typename,
        String tcin,
        @Nullable @JsonProperty("original_tcin") String originalTcin,
        Category category,
        @JsonProperty("ratings_and_reviews") RatingsAndReviews ratingsAndReviews,
        Item item,
        @JsonProperty("finds_stories") List<FindsStory> findsStories,
        @Nullable @JsonProperty("finds_posts") List<FindsPost> findsPosts,
        Price price,
        List<?> promotions) {
}
