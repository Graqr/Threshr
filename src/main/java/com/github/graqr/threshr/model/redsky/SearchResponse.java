package com.github.graqr.threshr.model.redsky;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record SearchResponse(

        @JsonProperty("bread_crumb_list")
        List<BreadCrumbList> breadCrumbList,

        @JsonProperty("facet_list")
        List<FacetList> facetList,

        Metadata metadata,

        @JsonProperty("sort_options")
        List<SortOption> sortOptions
) {
}
