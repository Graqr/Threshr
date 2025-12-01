package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Rating(
    @param:Nullable val average: Double,
    @param:Nullable val count: Long,
    @param:Nullable val distribution: Distribution,
    @param:JsonProperty("secondary_averages") @param:Nullable val secondaryAverages: List<SecondaryAverage>,
    @param:Nullable val value: Double,
    @param:JsonProperty("submitted_at") val submittedAt: String
) {}
