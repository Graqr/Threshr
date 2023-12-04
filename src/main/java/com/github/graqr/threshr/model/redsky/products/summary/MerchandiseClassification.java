package com.github.graqr.threshr.model.redsky.products.summary;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record MerchandiseClassification(
        @JsonProperty("class_id") Long classId,
        @JsonProperty("department_id") Long departmentId) {
}
