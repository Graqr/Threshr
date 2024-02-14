package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record SearchResponse(
        Metadata metadata,
        @JsonProperty("facet_list")
        List<Facet> facets,
        @JsonProperty("visual_facet_list")
        List<Facet> visualFacets) {
}
