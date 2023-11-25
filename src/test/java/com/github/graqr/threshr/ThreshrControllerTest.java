package com.github.graqr.threshr;

import com.github.graqr.threshr.model.targetProducts.Root;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class ThreshrControllerTest extends ThreshrTest {

    @Test
    void fetchProducts(String apiKey, ThreshrController threshrController) {
        HttpResponse<Root> response = threshrController.fetchProducts(apiKey, tcinList, targetStore);
        assertTrue(okResponse.test(response));
        assertTrue(productsCount.test(response));
    }
}