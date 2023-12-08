package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Map;

@Serdeable
public record Metadata(
        @JsonProperty("response_ids")
        String[] responseIds,
        int count,
        @JsonProperty("current_page")
        int currentPage,
        @Nullable
        String keyword,
        int offset,
        @JsonProperty("sort_by")
        String sortBy,
        @JsonProperty("total_pages")
        int totalPages,
        @JsonProperty("total_results")
        int totalResults,
        @JsonProperty("sort_options")
        Map<String, String> sortOptions) {
}
