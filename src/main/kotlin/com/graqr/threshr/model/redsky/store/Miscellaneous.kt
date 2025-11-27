package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Miscellaneous(@param:JsonProperty("google_cid") val googleCid: String) {}
