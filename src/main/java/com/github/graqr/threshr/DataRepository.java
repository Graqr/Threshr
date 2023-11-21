package com.github.graqr.threshr;

import com.github.graqr.threshr.model.products.Data;
import com.github.graqr.threshr.model.products.ProductSummary;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.http.HttpResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

import javax.transaction.Transactional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface DataRepository extends CrudRepository<@Valid Data, @Valid Long> {

    HttpResponse<Data> save(@NonNull @NotBlank ProductSummary... productSummaries);

    @Transactional
    default Data saveWithException(@NonNull @NotBlank ProductSummary... productSummaries) {
        save(productSummaries);
        throw new DataAccessException("test exception");
    }
}
