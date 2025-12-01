package com.graqr.threshr.circleStore.model.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable

@Serdeable
data class Compliance(
    @param:Nullable @param:JsonProperty("is_proposition_65") val isProposition65: Boolean,
    @param:Nullable @param:JsonProperty("is_snap_eligible") val isSnapEligible: Boolean
) {}
