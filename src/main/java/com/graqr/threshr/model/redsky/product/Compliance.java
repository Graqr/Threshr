package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.annotation.Nullable;

@Serdeable
public record Compliance(
        @Nullable @JsonProperty("is_proposition_65")
        Boolean isProposition65,
        @Nullable @JsonProperty("is_snap_eligible")
        Boolean isSnapEligible) {
}
