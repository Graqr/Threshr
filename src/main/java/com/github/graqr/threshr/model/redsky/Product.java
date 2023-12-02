package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Product(
        @JsonProperty("__typename")
        String typename,

        String tcin,

        @JsonProperty("original_tcin")
        String originalTcin,

        Item item,
        Parent parent,
        List<Promotion> promotions,
        Price price,

        @JsonProperty("ratings_and_reviews")
        RatingsAndReviews ratingsAndReviews,

        @JsonProperty("cgi_asset")
        CgiAsset cgiAsset
) {
}
