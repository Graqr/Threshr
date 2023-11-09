package com.github.peanutbutter.unicorn.tarvester.model;

import io.micronaut.core.annotation.Introspected;
import lombok.Getter;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;

@Getter
@Introspected
public class TcinList {
    long[] tcins;

    public TcinList(long[] tcins) {
        setId(tcins);
    }

    public void setId(long[] tcins) {
        LongPredicate tcin = t -> !String.valueOf(t).matches("\\d{8}");
        String badTcin = Arrays.stream(tcins)
                .filter(tcin)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        if (!badTcin.isEmpty()) {
            throw new CommandLine.PicocliException("the following are invalid tcin:" + badTcin);
        }
        this.tcins = tcins;
    }

    @SuppressWarnings("unused") // used by micronaut's url string interpolation
    public String getTcins() {
        return Arrays.stream(tcins)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
