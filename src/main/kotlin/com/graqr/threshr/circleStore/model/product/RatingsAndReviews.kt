package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class RatingsAndReviews(
    @param:JsonProperty("has_verified") val hasVerified: Boolean,
    val statistics: Statistics,
    @param:JsonProperty("most_recent") val mostRecent: List<MostRecent>,
    val photos: List<String>
) {}
