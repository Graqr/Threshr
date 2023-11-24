package com.github.graqr.threshr;

import com.github.graqr.threshr.model.targetProducts.ProductSummary;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import jakarta.validation.Valid;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface ProductSummaryRepository extends CrudRepository<@Valid ProductSummary, @Valid Long> {

    void insert(ProductSummary productSummaries);
}
