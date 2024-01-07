package com.github.graqr.threshr.model.silo;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity
public record TargetDepartment(long classId, long departmentId, String departmentName) {
}
