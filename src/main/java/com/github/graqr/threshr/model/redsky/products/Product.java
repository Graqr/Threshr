package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record Product(
        @JsonProperty("__typename") String typename,
        String tcin, Category category,
        @JsonProperty("ratings_and_reviews") RatingsAndReviews ratingsAndReviews, Item item,
        @JsonProperty("finds_stories")
        List<FindsStory> findsStories,
        @JsonProperty("finds_posts")
        List<FindsPost> findsPosts,
        Price price, List<?> promotions) {
}
