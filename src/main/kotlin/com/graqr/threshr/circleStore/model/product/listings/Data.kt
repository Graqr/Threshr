package com.graqr.threshr.circleStore.model.product.listings

import com.graqr.threshr.circleStore.model.product.Search
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Data(val search: Search) {
}
