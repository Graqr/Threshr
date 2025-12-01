package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PrimaryBrand(
    @param:JsonProperty("canonical_url") val canonicalUrl: String,
    @param:JsonProperty("linking_id") val linkingId: String,
    val name: String
) {}
