package com.graqr.threshr.model.redsky.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class RelatedCategory(
    val url: String, val title: String
) {}
