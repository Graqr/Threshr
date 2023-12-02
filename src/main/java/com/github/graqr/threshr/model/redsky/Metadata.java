package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Metadata(
        @JsonProperty("response_ids")
        List<String> responseIds,

        Long count,

        @JsonProperty("current_page")
        Long currentPage,

        Long offset,

        @JsonProperty("sort_by")
        String sortBy,

        @JsonProperty("total_pages")
        Long totalPages,

        @JsonProperty("total_results")
        Long totalResults
) {
}
