package com.github.peanutbutter.unicorn.tarvester;

import com.github.peanutbutter.unicorn.tarvester.model.products.Products;
import io.micronaut.http.HttpResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TarvesterClientTest extends TarvesterTest {

    @Test
    void fetchProducts() {
        HttpResponse<Products> response = client.productSummaryWithFulfillment(testApiKey, tcinList, targetStore);
        response.body();
        assertTrue(okResponse.test(response));
        System.out.println(response);
    }
}