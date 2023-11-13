package com.github.peanutbutter.unicorn.tarvester;

import com.github.peanutbutter.unicorn.tarvester.model.products.Products;
import io.micronaut.http.HttpResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TarvesterControllerTest extends TarvesterTest {

    @Test
    void fetchProducts() {
        HttpResponse<Products> response = controller.fetchProducts(testApiKey, tcinList, targetStore);
        response.body();
        assertTrue(okResponse.test(response));
        System.out.println(response);
    }
}