package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable
import java.util.*

@Serdeable
data class Metadata(
    @param:JsonProperty("response_ids") val responseIds: Array<String>,
    val count: Int,
    @param:JsonProperty("current_page") val currentPage: Int,
    @param:Nullable val keyword: String,
    val offset: Int,
    @param:JsonProperty("sort_by") val sortBy: String,
    @param:JsonProperty("total_pages") val totalPages: Int,
    @param:JsonProperty("total_results") val totalResults: Int,
    @param:JsonProperty("sort_options") val sortOptions: Map<String, String>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Metadata

        if (count != other.count) return false
        if (currentPage != other.currentPage) return false
        if (offset != other.offset) return false
        if (totalPages != other.totalPages) return false
        if (totalResults != other.totalResults) return false
        if (!responseIds.contentEquals(other.responseIds)) return false
        if (keyword != other.keyword) return false
        if (sortBy != other.sortBy) return false
        if (sortOptions != other.sortOptions) return false

        return true
    }

    override fun hashCode(): Int {
        return Objects.hash(
            count, currentPage, keyword, offset, sortBy, totalPages, totalResults, sortOptions
        ) * 31 + responseIds.contentHashCode()
    }

}
