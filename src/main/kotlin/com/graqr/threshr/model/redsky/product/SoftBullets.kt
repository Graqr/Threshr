package com.graqr.threshr.model.redsky.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class SoftBullets(val bullets: List<String>, val title: String) {}
