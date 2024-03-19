package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        Metadata castObject = (Metadata) object;
        return Objects.equals(count, castObject.count()) &&
                Arrays.equals(responseIds, castObject.responseIds()) &&
                Objects.equals(currentPage, castObject.currentPage()) &&
                Objects.equals(keyword, castObject.keyword()) &&
                Objects.equals(offset, castObject.offset()) &&
                Objects.equals(sortBy, castObject.sortBy()) &&
                Objects.equals(totalPages, castObject.totalPages()) &&
                Objects.equals(totalResults, castObject.totalResults()) &&
                Objects.equals(sortOptions, castObject.sortOptions());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions);
        result = 31 * result + Arrays.hashCode(responseIds);
        return result;
    }

}
