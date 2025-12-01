package com.graqr.threshr.circleStore.model.product.summary

import com.fasterxml.jackson.annotation.JsonProperty
import com.graqr.threshr.circle.model.product.ProductSummaryWithFulfillment
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Data(
        @param:JsonProperty("product_summaries")
        val productSummaryWithFulfillmentList: List<ProductSummaryWithFulfillment>
) {
}


