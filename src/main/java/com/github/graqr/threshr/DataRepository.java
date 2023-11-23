package com.github.graqr.threshr;

import com.github.graqr.threshr.model.products.Data;
import com.github.graqr.threshr.model.products.ProductSummary;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface DataRepository extends CrudRepository<@Valid Data, @Valid Long> {

    ProductSummary save(@NonNull @NotBlank ProductSummary productSummaries);

}
