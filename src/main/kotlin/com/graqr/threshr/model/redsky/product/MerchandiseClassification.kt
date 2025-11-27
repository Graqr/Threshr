package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class MerchandiseClassification(
    @param:JsonProperty("class_id") val classId: Long,
    @param:JsonProperty("department_id") val departmentId: Long,
    @param:JsonProperty("department_name") val departmentName: String
) {}
