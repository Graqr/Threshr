package com.github.graqr.threshr.model.silo;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

/**
 * A good is a form factor for a purchasable.
 *
 * <h3>Examples</h3>
 * <ul>
 *     <li>frozen goods</li>
 *     <li>baked goods</li>
 *     <li>fresh produce</li>
 * </ul>
 * @param id
 * @param name
 */
@Serdeable
@MappedEntity
public record Good(
        @GeneratedValue(GeneratedValue.Type.AUTO)
        @Id Long id,
        @NotNull String name) {
}
