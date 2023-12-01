package com.github.graqr.threshr;

import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.Tcin;
import com.github.graqr.threshr.model.redsky.ApiResponseData;
import io.micronaut.context.annotation.Property;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/product")
public class ThreshrController {

    @Inject
    ThreshrClient threshrClient;

    @Property(name = "threshr.CHANNEL")
    String CHANNEL;


    @Get("/summary")
    @SingleResult
    public HttpResponse<ApiResponseData> fetchProductSummaries(
            TargetStore targetStore,
            Tcin... tcins) {
        return threshrClient.productSummaryWithFulfillment(
                targetStore,
                CHANNEL,
                tcins);
    }


    @Get("/search")
    @SingleResult
    public HttpResponse<ApiResponseData> search(
            Tcin tcins,
            TargetStore targetStore) {
        return threshrClient.plpSearch("I'm a key", tcins, targetStore);
    }

}
