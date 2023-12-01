package com.github.graqr.threshr.model;

import io.micronaut.core.annotation.Introspected;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Introspected
public class Tcin {
    private String[] tcins;

    public Tcin(String... tcin) {
        setTcins(tcin);
    }

    public void setTcins(String... tcins) {
        Predicate<String> tcinCheck = t -> !String.valueOf(t).matches("\\d{8}");
        String badTcin = Arrays.stream(tcins)
                .filter(tcinCheck)
                .collect(Collectors.joining(", "));
        if (!badTcin.isEmpty()) {
            throw new CommandLine.PicocliException("the following are invalid tcin:" + badTcin);
        }
        this.tcins = tcins;
    }


    public String getTcins() {
        return Arrays.stream(tcins)
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }
}
