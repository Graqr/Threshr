package com.github.graqr.threshr.model;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@MappedEntity
public record HarvestedProduct(
        // https://micronaut-projects.github.io/micronaut-data/latest/guide/#javaRecords
        @Id @GeneratedValue @Nullable Long id,
        @NonNull @NotBlank @Size(min = 10000000, max = 99999999)
        long tcin, // target's ID system
        @NonNull @NotBlank
        String title) {
}
