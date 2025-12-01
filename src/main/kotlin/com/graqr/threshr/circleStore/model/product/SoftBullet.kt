package com.graqr.threshr.circleStore.model.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class SoftBullet(
    val bullets: List<String>
) {}
