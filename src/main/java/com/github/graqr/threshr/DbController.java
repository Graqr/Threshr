package com.github.graqr.threshr;

import com.github.graqr.threshr.model.products.ProductSummary;
import io.micronaut.http.annotation.Controller;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.NonNull;

@ExecuteOn(TaskExecutors.IO)
@Controller("/db")
public class DbController {
    protected final DataRepository dataRepository;

    public DbController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public ProductSummary save(@NonNull ProductSummary productSummaries) {
        return dataRepository.save(productSummaries);
    }
}
