package com.github.peanutbutter.unicorn.tarvester.controller;

import com.github.peanutbutter.unicorn.tarvester.client.HarvesterClient;
import com.github.peanutbutter.unicorn.tarvester.model.TargetStore;
import com.github.peanutbutter.unicorn.tarvester.model.TcinList;
import com.github.peanutbutter.unicorn.tarvester.model.targetProducts.Products;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/products")
public class HarvesterController {

    final HarvesterClient tarvesterClient;

    public HarvesterController(HarvesterClient tarvesterClient) {
        this.tarvesterClient = tarvesterClient;
    }

    @Get("/by-tcin")
    @SingleResult
    public HttpResponse<Products> fetchProducts(String apiToken, TcinList tcins, TargetStore targetStore) {
        return tarvesterClient.productSummaryWithFulfillment(apiToken, tcins, targetStore);
    }
}
