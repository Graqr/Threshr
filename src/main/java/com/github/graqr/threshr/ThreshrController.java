package com.github.graqr.threshr;

import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.Tcin;
import com.github.graqr.threshr.model.redsky.products.summary.ProductSummaryRoot;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/product")
public class ThreshrController {

    @Inject
    ThreshrClient threshrClient;


    @Get("/summary")
    @SingleResult
    public HttpResponse<ProductSummaryRoot> fetchProductSummaries(
            TargetStore targetStore,
            Tcin tcin) {
        return threshrClient.productSummaryWithFulfillment(targetStore, tcin);
    }
}