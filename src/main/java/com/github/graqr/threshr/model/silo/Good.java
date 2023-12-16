package com.github.graqr.threshr.model.silo;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


/**
 * General object for any purchasable. A 'good' differs from an 'product' in that a product is a more general umbrella.
 * Several items can refer to the same products. An example is 'Chocolate' is a product, whereas a 12 oz hershey's bag
 * of semisweet chocolate is an item.
 *
 * @param id
 * @param goodName
 */
@Serdeable
@MappedEntity
public record Good(
        @GeneratedValue
        @Id
        String id,

        @NotBlank
        String goodName,

        @NotEmpty
        Department[] department
) {

}
