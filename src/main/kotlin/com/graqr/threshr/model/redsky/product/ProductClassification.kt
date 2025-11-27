package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductClassification(
    @param:Nullable @param:JsonProperty("product_type") val productType: Long,
    @param:Nullable @param:JsonProperty("product_type_name") val productTypeName: String,
    @param:Nullable @param:JsonProperty("purchase_behavior") val purchaseBehavior: String,
    @param:Nullable @param:JsonProperty("item_type") val itemType: ItemType
) {}
