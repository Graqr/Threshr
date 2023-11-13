package com.github.graqr.threshr.model.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record MerchandiseClassification(
        @JsonProperty("class_id") Long classId,
        @JsonProperty("department_id") Long departmentId) {
}
