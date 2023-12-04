package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Serdeable
public record Data(
        @NotNull
        @JsonProperty("product_summaries")
        List<ProductSummary> productSummaries
) {
}
