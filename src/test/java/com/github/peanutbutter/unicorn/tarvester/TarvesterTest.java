package com.github.peanutbutter.unicorn.tarvester;

import com.github.peanutbutter.unicorn.tarvester.model.TargetStore;
import com.github.peanutbutter.unicorn.tarvester.model.TcinList;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;

import java.util.function.Predicate;

@MicronautTest
public class TarvesterTest {
    @Inject
    TarvesterController controller;

    @Inject
    TarvesterClient client;

    TcinList tcinList;
    TargetStore targetStore;
    String testApiKey = "9f36aeafbe60771e321a7cc95a78140772ab3e96";

    Predicate<HttpResponse<?>> okResponse = response -> response.code() >= 200 && response.code() < 300;

    @BeforeEach
    void setUp() {
        tcinList = new TcinList(new long[]{82691535, 12953464}); //corn & coke https://bit.ly/45V8dui https://bit.ly/40j4A0e
        targetStore = new TargetStore(
                1750,
                "UT",
                "84014-1752",
                40.91825,
                -111.887
        );
    }
}
