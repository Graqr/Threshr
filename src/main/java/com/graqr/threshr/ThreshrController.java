package com.graqr.threshr;

import com.graqr.threshr.model.TargetStore;
import com.graqr.threshr.model.TargetStorePdpSearch;
import com.graqr.threshr.model.Tcin;
import com.graqr.threshr.model.redsky.products.Product;
import com.graqr.threshr.model.redsky.products.ProductSummary;
import com.graqr.threshr.model.redsky.products.pdp.client.PdpClientRoot;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/product")
public class ThreshrController {

    @Inject
    ThreshrClient threshrClient;

    @Get("/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummary> fetchProductSummariesWithFulfillment(
            TargetStore targetStore,
            Tcin tcin) {
        return threshrClient
                .productSummaryWithFulfillment(targetStore, tcin)
                .body()
                .data()
                .productSummary();
    }

    public List<ProductSummary> fetchProductSummariesWithFulfillment(
            TargetStore targetStore,
            String... tcin) throws ThreshrException {
        return fetchProductSummariesWithFulfillment(targetStore,
                new Tcin(tcin));
    }

    @Get("/details")
    @SingleResult
    public Product fetchProductDetails(TargetStore targetStore, String tcin) throws ThreshrException {
        HttpResponse<PdpClientRoot> response = threshrClient.productDetails(new TargetStorePdpSearch(targetStore), tcin);
        if (response.code() != 200) {
            throw new ThreshrException("Query from pdp client endpoint didn't return 200.\n" + response.reason());
        }
        return response.body()
                .data()
                .product();
    }
}