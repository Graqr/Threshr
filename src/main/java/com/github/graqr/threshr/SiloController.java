package com.github.graqr.threshr;

import com.github.graqr.threshr.model.silo.Purchasable;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.validation.Valid;

import java.util.Optional;

@Validated
@Controller("/silo")
public class SiloController {
    protected final SiloRepository siloRepository;

    public SiloController(SiloRepository dataRepository) {
        this.siloRepository = dataRepository;
    }

    @("/{id}")
    public Optional<Purchasable> show(Long id) {
        return siloRepository.findById(id);
    }

    @Post
    public HttpResponse<Purchasable> update(@Body @Valid HarvestedItemUpdateCommand command) {
        siloRepository.update(command.getId(), command.getName());
        return HttpResponse.noContent().header(HttpHeaders.LOCATION, "I'm a location");
    }
}
