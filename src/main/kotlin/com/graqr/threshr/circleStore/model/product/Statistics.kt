package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Statistics(
    @param:JsonProperty("not_recommended_count") val notRecommendedCount: Long,
    @param:JsonProperty("question_count") val questionCount: Long,
    val rating: Rating,
    @param:JsonProperty("recommended_count") val recommendedCount: Long,
    @param:JsonProperty("recommended_percentage") val recommendedPercentage: Long,
    @param:JsonProperty("review_count") val reviewCount: Long
) {}
