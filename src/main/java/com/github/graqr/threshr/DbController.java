package com.github.graqr.threshr;

import com.github.graqr.threshr.model.targetProducts.ProductSummary;
import io.micronaut.http.annotation.Controller;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.NonNull;

@ExecuteOn(TaskExecutors.IO)
@Controller("/db")
public class DbController {
    protected final ProductSummaryRepository productSummaryRepository;

    public DbController(ProductSummaryRepository dataRepository) {
        this.productSummaryRepository = dataRepository;
    }

    public void insert(@NonNull ProductSummary productSummaries) {
        productSummaryRepository.insert(productSummaries);
    }
}
