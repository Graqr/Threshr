package com.github.graqr.threshr.model.redsky.products.plp.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Compliance(
        @JsonProperty("is_snap_eligible")
        boolean isSnapEligible
) {
}
