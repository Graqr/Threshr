package com.github.graqr.combine;

import com.github.graqr.combine.model.TargetStore;
import com.github.graqr.combine.model.TcinList;
import com.github.graqr.combine.model.products.Products;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/products")
public class CombineController {

    final CombineClient combineClient;

    public CombineController(CombineClient combineClient) {
        this.combineClient = combineClient;
    }

    @Get("/by-tcin")
    @SingleResult
    public HttpResponse<Products> fetchProducts(String apiToken, TcinList tcins, TargetStore targetStore) {
        return combineClient.productSummaryWithFulfillment(apiToken, tcins, targetStore);
    }
}
