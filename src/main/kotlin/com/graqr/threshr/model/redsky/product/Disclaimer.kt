package com.graqr.threshr.model.redsky.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Disclaimer(
    val description: String, val type: String
) {}
