package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Arrays;
import java.util.Objects;

@Serdeable
public record SearchRecommendations(
        @JsonProperty("category_id")
        String categoryId,
        @JsonProperty("related_categories")
        RelatedCategory[] relatedCategories) {
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SearchRecommendations castObject = (SearchRecommendations) object;
        return Objects.equals(categoryId, castObject.categoryId()) &&
                Arrays.equals(relatedCategories, castObject.relatedCategories);
    }
    @Override
    public int hashCode() {
        int hash = 31 * Objects.hash(categoryId);
        hash += Arrays.hashCode(relatedCategories);
        return hash;
    }
    @Override
    public String toString() {
        return String.format("SearchRecommendations[categoryId=%s, relatedCategories=%s]",
                categoryId, Arrays.toString(relatedCategories));
    }

}
