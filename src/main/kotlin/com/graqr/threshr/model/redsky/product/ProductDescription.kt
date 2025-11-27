package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductDescription(
    @param:JsonProperty("bullet_descriptions") val bulletDescriptions: List<String>,
    @param:JsonProperty("downstream_description") val downstreamDescription: String,
    @param:JsonProperty("soft_bullet_description") val softBulletDescription: String,
    @param:JsonProperty("soft_bullets") val softBullets: SoftBullets,
    val title: String
) {}
