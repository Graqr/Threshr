package com.github.peanutbutter.unicorn.tarvester.model;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
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
    void testToString() {
        Stream.of(1, 5).forEach(size -> {
            tcinList = new TcinList(randomTcinList.apply(size));
            if (!tcinList.toString().matches("^tcins=\\d{8}(%2C\\d{8})*$")) {
                throw new AssertionFailedError("The provided tcins string, \"" + tcinList.toString() + "\", is invalid.");
            }
        });
    }

    @Test
    void setId() {
        Stream.of(1, 5).forEach(size -> {
            tcinList = new TcinList(randomTcinList.apply(size));
            assertDoesNotThrow(() -> tcinList.setId(randomTcinList.apply(random.nextInt(0, 5))));
        });
    }

    @Test
    void setIdWithBadIdSize() {
        Stream.of(1, 5).forEach(size -> assertThrows(
                CommandLine.PicocliException.class,
                () -> tcinList = new TcinList(randomBadTcinList.apply(size))));
    }
}