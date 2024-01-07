package com.github.graqr.threshr;

import com.github.graqr.threshr.model.silo.Purchasable;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface SiloRepository extends PageableRepository<Purchasable, Long> {
    Purchasable save(@NonNull Purchasable purchasable);
}
