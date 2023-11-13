package com.github.graqr.combine;

import com.github.graqr.combine.model.TargetStore;
import com.github.graqr.combine.model.TcinList;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;

import java.util.function.Predicate;

@MicronautTest
public class CombineTest {
    @Inject
    CombineController controller;

    @Inject
    CombineClient client;

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
