package com.github.graqr.threshr.model.silo;

import com.github.graqr.threshr.model.redsky.api.Item;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity
public record HarvestedItem(
        @GeneratedValue
        @Id
        Long id,
        Item item) {
}
