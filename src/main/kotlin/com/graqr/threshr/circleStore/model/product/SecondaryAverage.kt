package com.graqr.threshr.circleStore.model.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class SecondaryAverage(val id: String, val label: String, val range: Long, val type: String, val value: Double) {}
