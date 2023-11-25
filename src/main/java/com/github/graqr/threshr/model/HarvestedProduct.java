package com.github.graqr.threshr.model;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@MappedEntity
public record HarvestedProduct(
        @Id @GeneratedValue @Nullable
        Long id,

        @AutoPopulated(updateable = false)
        DateCreated dateCreated,

        @NonNull @NotBlank @Size(min = 10000000, max = 99999999)
        long tcin, // target's ID system

        @NonNull @NotBlank
        String title,

        double price) {
}
