package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class SearchRecommendations(
    @param:JsonProperty("category_id") val categoryId: String,
    @param:JsonProperty("related_categories") val relatedCategories: List<RelatedCategory>
) {
    @Override
    override fun toString(): String {
        return String.format(
            "SearchRecommendations[categoryId=%s, relatedCategories=%s]", categoryId, relatedCategories
        )
    }

}
