package com.github.graqr.threshr;

import com.github.graqr.threshr.model.HarvestedProduct;
import com.github.graqr.threshr.model.TargetStore;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import java.util.function.Predicate;

@MicronautTest
public class ThreshrTest {
    @Value("${micronaut.http.services.redsky-api.visitorId}")
    String visitorId;

    static TargetStore targetStore = new TargetStore(
                1750,
            "UT",
            "84014-1752",
            40.91825,
            -111.887
    );
    HarvestedProduct[] harvestedProducts = new HarvestedProduct[]{
            new HarvestedProduct(
                    null,
                    null,
                    76382974,
                    "Quest Protein Bar - Pumpkin Pie - 4ct",
                    11.00),
            new HarvestedProduct(
                    null,
                    null,
                    12312312,
                    "hallabee hoobee whatee",
                    123.54
            )
    };

    Predicate<HttpResponse<?>> okResponse = response ->
            response.code() >= 200
                    && response.code() < 300;

}
