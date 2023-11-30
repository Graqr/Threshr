package com.github.graqr.threshr;

import com.github.graqr.threshr.model.RedskyQueryMetadata;
import com.github.graqr.threshr.model.TargetStore;
import com.github.graqr.threshr.model.TcinList;
import com.github.graqr.threshr.model.redsky.ApiResponseData;
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
    public HttpResponse<ApiResponseData> fetchProductSummaries(
            RedskyQueryMetadata metadata,
            String apiToken,
            TcinList tcins,
            TargetStore targetStore) {
        return threshrClient.productSummaryWithFulfillment(metadata, apiToken, tcins, targetStore);
    }


    @Get("/search")
    @SingleResult
    public HttpResponse<ApiResponseData> search(
            RedskyQueryMetadata metadata,
            String apiToken,
            TcinList tcins,
            TargetStore targetStore) {
        return threshrClient.plpSearch(metadata, apiToken, tcins, targetStore);
    }

}
