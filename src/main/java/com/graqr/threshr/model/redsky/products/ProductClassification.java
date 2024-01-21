package com.graqr.threshr.model.redsky.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductClassification(
        @Nullable @JsonProperty("product_type") Long productType,
        @Nullable @JsonProperty("product_type_name") String productTypeName,
        @Nullable @JsonProperty("purchase_behavior") String purchaseBehavior,
        @Nullable @JsonProperty("item_type") ItemType itemType) {
}
