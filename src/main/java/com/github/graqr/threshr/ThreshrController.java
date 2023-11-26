package com.github.graqr.threshr;

import com.github.graqr.threshr.model.RedskyQueryMetadata;
import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.TcinList;
import com.github.graqr.threshr.model.redsky.ProductSummary;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/product")
public class ThreshrController {

    final ThreshrClient threshrClient;
    final RedskyQueryMetadata metadata;

    public ThreshrController(RedskyQueryMetadata metadata,
                             ThreshrClient threshrClient) {
        this.metadata = metadata;
        this.threshrClient = threshrClient;
    }

    @Get("/summary")
    @SingleResult
    public HttpResponse<ProductSummary> fetchProductSummaries(
            String apiToken,
            TcinList tcins,
            TargetStore targetStore) {
        return threshrClient.productSummaryWithFulfillment(metadata, apiToken, tcins, targetStore);
    }

//    @Get("/product-listing")
//    @SingleResult
//    public httpResponse<ProductPricing>

}
