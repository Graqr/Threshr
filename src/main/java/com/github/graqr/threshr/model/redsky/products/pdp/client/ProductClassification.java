package com.github.graqr.threshr.model.redsky.products.pdp.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ProductClassification(
        @JsonProperty("product_type") Long productType,
        @JsonProperty("product_type_name") String productTypeName,
        @JsonProperty("purchase_behavior") String purchaseBehavior) {
}
