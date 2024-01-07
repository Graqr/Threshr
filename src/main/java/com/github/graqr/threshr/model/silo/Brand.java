package com.github.graqr.threshr.model.silo;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

@Serdeable
@MappedEntity
public record Brand(
        @GeneratedValue(GeneratedValue.Type.AUTO)
        @Id Long id,
        @NotNull String name) {
}
