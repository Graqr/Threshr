package com.graqr.threshr.circleStore.model.store

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class MainHours(val days: List<Day>) {}
