package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Handling(
    @param:JsonProperty("import_designation_description") val importDesignationDescription: String
) {}
