package com.github.graqr.threshr;

import com.github.graqr.threshr.model.targetProducts.Root;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class ThreshrClientTest extends ThreshrTest {

    @Test
    void fetchProducts(ThreshrClient client) {
        HttpResponse<Root> response = client.productSummaryWithFulfillment(testApiKey, tcinList, targetStore);
        response.body();
        assertTrue(okResponse.test(response));
        assertTrue(productsCount.test(response));
    }
}