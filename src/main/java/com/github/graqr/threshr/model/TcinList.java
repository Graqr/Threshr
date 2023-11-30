package com.github.graqr.threshr.model;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Introspected
public class TcinList {
    long[] tcins;

    public TcinList(long... tcins) {
        this.tcins = tcins;
    }

    @SuppressWarnings("unused") // used by micronaut's url string interpolation
    public String getTcins() {
        return Arrays.stream(tcins)
                .mapToObj(Objects::toString)
                .collect(Collectors.joining(","));
    }
}
