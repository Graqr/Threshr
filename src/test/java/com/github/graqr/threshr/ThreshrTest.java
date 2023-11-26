package com.github.graqr.threshr;

import com.github.graqr.threshr.model.HarvestedProduct;
import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.TcinList;
import com.github.graqr.threshr.model.redsky.Root;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;

import java.util.Objects;
import java.util.function.Predicate;

@MicronautTest
public class ThreshrTest {

    static TcinList tcinList;
    static TargetStore targetStore;
    HarvestedProduct[] harvestedProducts = new HarvestedProduct[]{
            new HarvestedProduct(null, null, 76382974, "Quest Protein Bar - Pumpkin Pie - 4ct", 11.00)
    };

    Predicate<HttpResponse<?>> okResponse = response -> response.code() >= 200 && response.code() < 300;
    Predicate<HttpResponse<Root>> productsCount = response -> 2 == Objects.requireNonNull(response.body())
            .data()
            .productSummary()
            .size();

    @BeforeAll
    static void setUp() {
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
