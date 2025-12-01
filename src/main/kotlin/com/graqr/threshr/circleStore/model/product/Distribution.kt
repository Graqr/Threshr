package com.graqr.threshr.circleStore.model.product

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Distribution(
    val rating1: Long, val rating2: Long, val rating3: Long, val rating4: Long, val rating5: Long
) {}
