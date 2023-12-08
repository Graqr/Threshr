package com.github.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Category(
        @JsonProperty("parent_category_id")
        String parentCategoryId,
        String name) {
}
