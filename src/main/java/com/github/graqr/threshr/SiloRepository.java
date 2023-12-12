package com.github.graqr.threshr;

import com.github.graqr.threshr.model.silo.HarvestedItem;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import jakarta.validation.Valid;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface SiloRepository extends CrudRepository<@Valid HarvestedItem, Long> {
    void insert(HarvestedItem items);
}
