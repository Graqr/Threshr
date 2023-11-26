package com.github.graqr.threshr;

import com.github.graqr.threshr.model.RedskyQueryMetadata;
import com.github.graqr.threshr.model.TcinList;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class ThreshrControllerTest extends ThreshrTest {

    @Test
    void fetchProducts(ThreshrController threshrController) {

        assertTrue(okResponse.test(threshrController.fetchProductSummaries(
                new RedskyQueryMetadata(visitorId, "5q0f2", "WEB"),
                System.getenv("REDSKY_TOKEN"),
                new TcinList(harvestedProducts[0].tcin()),
                targetStore)));
    }
}