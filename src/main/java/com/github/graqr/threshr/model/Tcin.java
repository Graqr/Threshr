package com.github.graqr.threshr.model;

import io.micronaut.core.annotation.Introspected;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Introspected
public class Tcin {
    String[] tcins;

    public Tcin(String... tcin) {
        setTcins(tcin);
    }

    /**
     * checks if the provided string is appropriately sized and only digits prior to assigning the field.
     *
     * @param tcins var arg of String TCIN values. See
     *              <a href="https://partners.target.com/termsandconditions">partners agreement</a> under
     *              "Merchandiser Datafeed"
     */
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

    public String getTcinByIndex(int index) {
        if (index >= tcins.length) {
            throw new CommandLine.PicocliException(String.format(
                    "cannot retrieve value at index %s from an array with %s indices.",
                    index,
                    tcins.length));
        }
        return tcins[index];
    }

    public int getTcinCount() {
        return tcins.length;
    }


    public String getTcins() {
        return Arrays.stream(tcins)
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }
}