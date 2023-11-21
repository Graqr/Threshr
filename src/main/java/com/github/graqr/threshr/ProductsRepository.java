package com.github.graqr.threshr;

import com.github.graqr.threshr.model.products.Products;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import jakarta.validation.Valid;

@Repository
public abstract class ProductsRepository implements CrudRepository<@Valid Products, @Valid Long> {

}
