package com.graqr.threshr.model.redsky.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class MostRecent(
    val id: String, val text: String, val author: Author, val title: String, val rating: Rating
) {}
