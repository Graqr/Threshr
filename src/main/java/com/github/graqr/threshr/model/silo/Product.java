package com.github.graqr.threshr.model.silo;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


/**
 * General type for varying purchasables. Chocolate, Baked Goods, Frozen Goods Several purchasables share a product, and some purchasables have more than one product.
 * An example is 'Chocolate' is a product, whereas a 12 oz hershey's bag of semisweet chocolate is an item.
 *
 * @param id generated unique identifier
 * @param goodName human-readable name for a product
 */
@Serdeable
@MappedEntity
public record Product(
        @GeneratedValue
        @Id
        String id,

        @NotBlank
        String goodName,

        @NotEmpty
        TargetDepartment[] department
) {

}
