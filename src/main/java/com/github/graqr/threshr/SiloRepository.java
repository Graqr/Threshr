package com.github.graqr.threshr;

import com.github.graqr.threshr.model.silo.Product;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import jakarta.validation.Valid;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface SiloRepository extends CrudRepository<Product, @Valid Long> {

    void insert(Product Product);
}
