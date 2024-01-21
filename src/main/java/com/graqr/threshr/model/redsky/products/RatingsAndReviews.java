package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record RatingsAndReviews(
        @JsonProperty("has_verified") Boolean hasVerified, Statistics statistics,
        @JsonProperty("most_recent") List<MostRecent> mostRecent, List<String> photos) {
}
