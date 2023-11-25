package com.github.graqr.threshr;

import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.TcinList;
import com.github.graqr.threshr.model.targetProducts.Root;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/targetProducts")
public class ThreshrController {

    final ThreshrClient threshrClient;

    public ThreshrController(ThreshrClient threshrClient) {
        this.threshrClient = threshrClient;
    }

    @Get("/by-tcin")
    @SingleResult
    public HttpResponse<Root> fetchProducts(String apiToken, TcinList tcins, TargetStore targetStore) {
        return threshrClient.productSummaryWithFulfillment(apiToken, tcins, targetStore);
    }
}
