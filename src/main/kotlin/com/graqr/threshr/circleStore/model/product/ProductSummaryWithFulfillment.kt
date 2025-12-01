package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductSummaryWithFulfillment(
    @param:JsonProperty("__typename") val typename: String,
    val tcin: String,
    val item: Item,
    @param:Nullable val fulfillment: Fulfillment
) {}
