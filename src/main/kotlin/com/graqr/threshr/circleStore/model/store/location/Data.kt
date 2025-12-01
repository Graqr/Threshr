package com.graqr.threshr.circleStore.model.store.location

import com.graqr.threshr.circleStore.model.store.Store
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Data(val store: Store) {
}
