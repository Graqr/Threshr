package com.graqr.threshr;

import com.graqr.threshr.model.queryparam.Place;
import com.graqr.threshr.model.queryparam.TargetStore;
import com.graqr.threshr.model.queryparam.TargetStorePdpSearch;
import com.graqr.threshr.model.queryparam.Tcin;
import com.graqr.threshr.model.redsky.product.Product;
import com.graqr.threshr.model.redsky.product.ProductSummary;
import com.graqr.threshr.model.redsky.store.NearbyStores;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller()
public class Threshr {

    @Inject
    ThreshrClient threshrClient;

    @Get("/product/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummary> fetchProductSummaries(TargetStore targetStore, Tcin tcin) throws ThreshrException {
        return checkForNull(threshrClient.getProductSummary(targetStore, tcin))
                .data()
                .productSummary();
    }

    @Get("/product/summary-with-fulfillment")
    @SingleResult
    public List<ProductSummary> fetchProductSummaries(TargetStore targetStore, String... tcin) throws ThreshrException {
        return fetchProductSummaries(targetStore, new Tcin(tcin));
    }

    @Get("/product/details")
    @SingleResult
    public Product fetchProductDetails(TargetStore targetStore, String tcin) throws ThreshrException {
        return checkForNull(threshrClient.getProductDetails(new TargetStorePdpSearch(targetStore), tcin))
                .data()
                .product();
    }

    @Get("/stores/locations-query")
    @SingleResult
    public NearbyStores queryStoreLocations(Place place) throws ThreshrException {
        return queryStoreLocations(5, 100, place);
    }

    @Get("/stores/locations-query")
    @SingleResult
    public NearbyStores queryStoreLocations(int limit, int within, Place place) throws ThreshrException {
        return checkForNull(threshrClient.getNearbyStores(limit, within, place.getPlace()))
                .data()
                .nearbyStores();
    }

    private <T> T checkForNull(HttpResponse<T> response) throws ThreshrException {
        if (null == response.body()) {
            throw new ThreshrException(String.format("response body of HttpResponse<%s> is null", response
                    .body()
                    .getClass()
                    .getName()));
        }
        return response.body();
    }
}