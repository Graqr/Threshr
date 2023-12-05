package com.github.graqr.threshr.model.redsky.products.plp.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Facet(
        @JsonProperty("facet_id")
        String facetId,
        String type,
        @JsonProperty("display_name")
        String displayName,
        boolean expand
) {

}
