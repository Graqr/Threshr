package com.graqr.threshr.model.redsky.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ItemType(
    val name: String, val type: String
) {}
