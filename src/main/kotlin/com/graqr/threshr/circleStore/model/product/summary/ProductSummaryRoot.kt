package com.graqr.threshr.circleStore.model.product.summary

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductSummaryRoot(val data: Data) {
}
