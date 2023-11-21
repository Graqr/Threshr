package com.github.graqr.threshr;

import com.github.graqr.threshr.model.products.Data;
import com.github.graqr.threshr.model.products.ProductSummary;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.validation.constraints.NotBlank;

@ExecuteOn(TaskExecutors.IO)
@Controller("/db")
public class DbController {
    protected final DataRepository dataRepository;

    public DbController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public HttpResponse<Data> save(@NotBlank ProductSummary... productSummaries) {
        return dataRepository.save(productSummaries);
    }
}
