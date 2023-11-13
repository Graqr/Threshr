package com.github.graqr.threshr.model;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TcinListTest {
    int min = 10000000;
    int max = 100000000;
    Random random = new Random();
    TcinList tcinList;
    Function<Integer, long[]> randomTcinList = size ->
            random.longs(size, min, max)
                    .toArray();
    Function<Integer, long[]> randomBadTcinList = size ->
            random.longs(size)
                    .map(tcin -> {
                        if (random.nextBoolean()) {
                            return random.nextLong() + 99999999;
                        }
                        return tcin;
                    }).toArray();

    @Test
    void setId() {
        Stream.of(1, 2).forEach(size -> {
            tcinList = new TcinList(randomTcinList.apply(size));
            assertDoesNotThrow(() -> tcinList.setId(randomTcinList.apply(random.nextInt(0, 2))),
                    "a tcins validation error was thrown when none was expected.");
        });
    }

    @Test
    void setIdWithBadIdSize() {
        Stream.of(1, 5).forEach(size -> assertThrows(
                CommandLine.PicocliException.class,
                () -> tcinList = new TcinList(randomBadTcinList.apply(size)),
                "no validation error was thrown when a poorly sized tcins was provided."));
    }
}