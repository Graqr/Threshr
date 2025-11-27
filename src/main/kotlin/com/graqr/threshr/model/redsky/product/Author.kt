package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Author(
    val nickname: String, @param:JsonProperty("external_id") val externalId: String
) {}
