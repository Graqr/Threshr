package com.github.graqr.threshr.model;

import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Introspected
public class Tcin {
    @Pattern(regexp = "\\d*")
    @Size(min = 8, max = 9)
    String tcin;

    public Tcin(String tcin) {
        this.tcin = tcin;
    }
}
