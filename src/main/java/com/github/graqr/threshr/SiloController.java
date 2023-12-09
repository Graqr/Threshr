package com.github.graqr.threshr;

import com.github.graqr.threshr.model.silo.Product;
import io.micronaut.http.annotation.Controller;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.NonNull;

@ExecuteOn(TaskExecutors.IO)
@Controller("/silo")
public class SiloController {
    protected final SiloRepository productSummaryRepository;

    public SiloController(SiloRepository dataRepository) {
        this.productSummaryRepository = dataRepository;
    }

    public void insert(@NonNull Product harvestedProduct) {
        productSummaryRepository.insert(harvestedProduct);
    }
}
