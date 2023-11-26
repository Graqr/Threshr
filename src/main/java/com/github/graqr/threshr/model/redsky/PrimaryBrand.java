package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

record PrimaryBrand(
        @JsonProperty("canonical_url")
        String canonicalUrl,
        @JsonProperty("linking_id")
        String linkingId,
        String name
) {
}
