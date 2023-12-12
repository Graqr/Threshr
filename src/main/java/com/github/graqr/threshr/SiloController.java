package com.github.graqr.threshr;

import com.github.graqr.threshr.model.silo.HarvestedItem;
import io.micronaut.http.annotation.Controller;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.validation.Valid;

@ExecuteOn(TaskExecutors.IO)
@Controller("/silo")
public class SiloController {
    protected final SiloRepository siloRepository;

    public SiloController(SiloRepository dataRepository) {
        this.siloRepository = dataRepository;
    }

    public void insert(@Valid HarvestedItem harvestedItem) {
        siloRepository.insert(harvestedItem);
    }
}
