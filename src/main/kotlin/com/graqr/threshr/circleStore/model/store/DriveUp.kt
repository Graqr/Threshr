package com.graqr.threshr.circleStore.model.store

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class DriveUp(val latitude: Double, val longitude: Double, val radius: Long) {}
