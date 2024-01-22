package com.graqr.threshr;

import com.graqr.threshr.model.TargetStore;
import com.graqr.threshr.model.Tcin;
import com.graqr.threshr.model.redsky.products.ProductSummary;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/product")
public class ThreshrController {

    @Inject
    ThreshrClient threshrClient;


    @Get("/summary")
    @SingleResult
    public List<ProductSummary> fetchProductSummaries(
            TargetStore targetStore,
            Tcin tcin) {
        return threshrClient
                .productSummaryWithFulfillment(targetStore, tcin)
                .body()
                .data()
                .productSummary();
    }
}