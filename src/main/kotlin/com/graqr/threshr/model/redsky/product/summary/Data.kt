package com.graqr.threshr.model.redsky.product.summary

import com.fasterxml.jackson.annotation.JsonProperty
import com.graqr.threshr.model.redsky.product.ProductSummaryWithFulfillment
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Data(
        @param:JsonProperty("product_summaries")
        val productSummaryWithFulfillmentList: List<ProductSummaryWithFulfillment>
) {
}


