package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class FindsPost(
    val id: String,
    val caption: String,
    val url: String,
    @param:JsonProperty("placeholder_color") val placeholderColor: String,
    val user: User,
    val image: Image
) {}
