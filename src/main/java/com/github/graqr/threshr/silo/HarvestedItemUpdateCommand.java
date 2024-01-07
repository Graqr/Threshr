package com.github.graqr.threshr.silo;

import com.github.graqr.threshr.model.redsky.api.Item;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Serdeable
@Data
public class HarvestedItemUpdateCommand {
    @NotNull
    private final Long id;

    @NotBlank
    private final Item item;
}
