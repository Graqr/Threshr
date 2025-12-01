package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class SearchResponse(
    val metadata: Metadata,
    @param:JsonProperty("facet_list") val facets: List<Facet>,
    @param:JsonProperty("visual_facet_list") val visualFacets: List<Facet>
) {}
