package com.graqr.threshr.model.redsky.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class SoftBullet(
    val bullets: List<String>
) {}
