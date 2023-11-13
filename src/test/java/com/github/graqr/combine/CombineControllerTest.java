package com.github.graqr.combine;

import com.github.graqr.combine.model.products.Products;
import io.micronaut.http.HttpResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CombineControllerTest extends CombineTest {

    @Test
    void fetchProducts() {
        HttpResponse<Products> response = controller.fetchProducts(testApiKey, tcinList, targetStore);
        response.body();
        assertTrue(okResponse.test(response));
        System.out.println(response);
    }
}