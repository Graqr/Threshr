package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Category(
    @param:JsonProperty("parent_category_id") val parentCategoryId: String, val name: String
) {}
