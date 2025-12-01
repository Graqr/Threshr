package com.graqr.threshr.circleStore.model.product.details

import com.graqr.threshr.circleStore.model.product.Product
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Data(val product: Product) {
}
