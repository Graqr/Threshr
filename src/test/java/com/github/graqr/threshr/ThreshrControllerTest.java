package com.github.graqr.threshr;

import com.github.graqr.threshr.model.redsky.ProductSummary;
import com.github.graqr.threshr.model.redsky.Root;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class ThreshrControllerTest extends ThreshrTest {

    @Test
    void fetchProducts(ThreshrController threshrController) {

        assertTrue(okResponse.test(threshrController
                        .fetchProductSummaries(
                                System.getenv("REDSKY_TOKEN"),
                                tcinList,
                                targetStore)
                )
        );
    }
}