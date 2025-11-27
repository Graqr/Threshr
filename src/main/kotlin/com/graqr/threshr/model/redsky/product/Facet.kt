package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Facet(
    @param:JsonProperty("facet_id") val facetId: String,
    val type: String,
    @param:JsonProperty("display_name") val displayName: String,
    val expand: Boolean
) {

}
