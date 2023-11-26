package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

record FacetList(
        @JsonProperty("facet_id")
        String facetId,

        String type,

        @JsonProperty("display_name")
        String displayName,

        Boolean expand,

        List<Option> options
) {
}
