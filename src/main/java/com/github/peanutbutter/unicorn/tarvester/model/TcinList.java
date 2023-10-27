package com.github.peanutbutter.unicorn.tarvester.model;

import lombok.Getter;
import lombok.Setter;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;

@Getter
@Setter
public class TcinList {
    long[] id;

    public TcinList(long[] id) {
        LongPredicate tcin = t -> !String.valueOf(t).matches("\\d{8}");
        String badTcin = Arrays.stream(id)
                .filter(tcin)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        if (!badTcin.isEmpty()) {
            throw new CommandLine.PicocliException("the following are invalid tcin:" + badTcin);
        }
        this.id = id;
    }


    @Override
    public String toString() {
        return "tcins=" + Arrays.stream(id)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("%2C"));
    }
}
